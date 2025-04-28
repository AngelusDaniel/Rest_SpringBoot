package AngelusDaniel.services;


import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.stereotype.Service;

import AngelusDaniel.controllers.PersonController;
import AngelusDaniel.data.dto.v1.PersonDTO;
import AngelusDaniel.data.dto.v2.PersonDTOV2;
import AngelusDaniel.exception.RequiredObjectIsNullException;
import AngelusDaniel.exception.ResourceNotFoundException;
import AngelusDaniel.mapper.custom.PersonMapper;

import static AngelusDaniel.mapper.ObjectMapper.parseListObject;
import static AngelusDaniel.mapper.ObjectMapper.parseObject;
import AngelusDaniel.model.Person;
import AngelusDaniel.repository.PersonRepository;

@Service
public class PersonServices {

  //private final AtomicLong counter = new AtomicLong();

  @Autowired
  PersonRepository repository;

  @Autowired
  PersonMapper converter;

  private Logger logger = Logger.getLogger(PersonServices.class.getName());

  public List<PersonDTO> findAll(){
    logger.info("Finding all people!");

    var dto =  parseListObject(repository.findAll(), PersonDTO.class);
    dto.forEach(this::addHateoasLinks);
    //mesmo que dto.foeach(dto -> addHateoasLinks(dto));
    return dto;
  }

  public List<PersonDTOV2> findAllV2(){
    logger.info("Finding all people!");

    return parseListObject(repository.findAll(), PersonDTOV2.class);
  }

  public PersonDTO findById(Long id){
    logger.info("Finding one person!");

    var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
    var dto = parseObject(entity, PersonDTO.class);
    addHateoasLinks(dto);
    return dto;
  }



  public PersonDTOV2 findByIdV2(Long id){
    logger.info("Finding one person!");

    var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
    return parseObject(entity, PersonDTOV2.class);
  }

  public PersonDTO create(PersonDTO person) {

    if(person == null) throw new RequiredObjectIsNullException();
    logger.info("Creating one person!");
    var entity = parseObject(person, Person.class);
    var dto =  parseObject(repository.save(entity), PersonDTO.class);
    addHateoasLinks(dto);
    return dto;
  }

  public PersonDTOV2 createV2(PersonDTOV2 person) {
    logger.info("Creating one person!");
    var entity = converter.convertDTOToEntity(person);
    return converter.convertEntityToDTO(repository.save(entity));
    
  }

  public PersonDTO update(PersonDTO person) {

    if(person == null) throw new RequiredObjectIsNullException();

    logger.info("Updating one person!");

    Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
    entity.setFirstName(person.getFirstName());
    entity.setLastName(person.getLastName());
    entity.setAddress(person.getAddress());
    entity.setGender(person.getGender());
    var dto = parseObject(repository.save(entity), PersonDTO.class);
    addHateoasLinks(dto);
    return dto;
  }


  public void delete(Long id) {
    logger.info("Deleting one person!");
    Person person = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
    repository.delete(person);
    

  }


  private void addHateoasLinks(PersonDTO dto) {
 
    dto.add(linkTo(methodOn(PersonController.class).findById(dto.getId())).withSelfRel().withType("GET"));
    dto.add(linkTo(PersonController.class).slash(dto.getId()).withRel("delete").withType("DELETE"));
    dto.add(linkTo(methodOn(PersonController.class).findAll()).withRel("findAll").withType("GET"));
    dto.add(linkTo(methodOn(PersonController.class).create(dto)).withRel("create").withType("POST"));
    dto.add(linkTo(methodOn(PersonController.class).update(dto)).withRel("update").withType("PUT"));
  }

}

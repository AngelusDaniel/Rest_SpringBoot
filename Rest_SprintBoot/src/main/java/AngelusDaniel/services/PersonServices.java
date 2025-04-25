package AngelusDaniel.services;


import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AngelusDaniel.data.dto.v1.PersonDTO;
import AngelusDaniel.data.dto.v2.PersonDTOV2;
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

    return parseListObject(repository.findAll(), PersonDTO.class);
  }

  public PersonDTO findById(Long id){
    logger.info("Finding one person!");

    var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
    return parseObject(entity, PersonDTO.class);
  }

  public PersonDTO create(PersonDTO person) {
    logger.info("Creating one person!");
    var entity = parseObject(person, Person.class);
    return parseObject(repository.save(entity), PersonDTO.class);
    
  }

  public PersonDTOV2 createV2(PersonDTOV2 person) {
    logger.info("Creating one person!");
    var entity = converter.convertDTOToEntity(person);
    return converter.convertEntityToDTO(repository.save(entity));
    
  }

  public PersonDTO update(PersonDTO person) {
    logger.info("Updating one person!");
    if (person == null) {
      return null;
    }
    Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
    entity.setFirstName(person.getFirstName());
    entity.setLastName(person.getLastName());
    entity.setAddress(person.getAddress());
    entity.setGender(person.getGender());
    return parseObject(repository.save(entity), PersonDTO.class);
  }

  public void delete(Long id) {
    logger.info("Deleting one person!");
    Person person = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
    repository.delete(person);
  }

}

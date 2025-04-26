package AngelusDaniel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import AngelusDaniel.data.dto.v1.PersonDTO;
import AngelusDaniel.data.dto.v2.PersonDTOV2;
import AngelusDaniel.services.PersonServices;

@RequestMapping("/api/person/v1")
@RestController
public class PersonController {

  @Autowired
  private PersonServices service;

  @GetMapping(value = "/{id}", 
    produces = {MediaType.APPLICATION_JSON_VALUE, 
    MediaType.APPLICATION_XML_VALUE})
  public PersonDTO findById(@PathVariable("id") Long id) {
    return service.findById(id);
  }

  @GetMapping(value = "/",
    produces = {MediaType.APPLICATION_JSON_VALUE, 
      MediaType.APPLICATION_XML_VALUE, 
      MediaType.APPLICATION_YAML_VALUE}
      )
  public List<PersonDTO> findAll() {
    return service.findAll();
  }

  @PostMapping(value = "/",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public PersonDTO create(@RequestBody PersonDTO person) {
    return service.create(person);
  }


  @PutMapping(value= "/",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public PersonDTO update(@RequestBody PersonDTO person) {
    return service.update(person);
  }

  @DeleteMapping(value= "/{id}")
  public void delete(@PathVariable("id") Long id) {
    service.delete(id);
  }


}

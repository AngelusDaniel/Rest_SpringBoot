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

import AngelusDaniel.controllers.docs.PersonControllerDocs;
import AngelusDaniel.data.dto.v1.PersonDTO;
import AngelusDaniel.services.PersonServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/person/v1")
@Tag(name = "People", description = "Endpoints for managing persons")
public class PersonController implements PersonControllerDocs {

  @Autowired
  private PersonServices service;

  @Override
  @GetMapping(value = "/{id}", 
    produces = {MediaType.APPLICATION_JSON_VALUE, 
    MediaType.APPLICATION_XML_VALUE})
  public PersonDTO findById(@PathVariable("id") Long id) {
    return service.findById(id);
  }

  @Override
  @GetMapping(value = "/",
    produces = {MediaType.APPLICATION_JSON_VALUE, 
      MediaType.APPLICATION_XML_VALUE, 
      MediaType.APPLICATION_YAML_VALUE}
      )
  public List<PersonDTO> findAll() {
    return service.findAll();
  }

  @Override
  @PostMapping(value = "/",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public PersonDTO create(@RequestBody PersonDTO person) {
    return service.create(person);
  }


  @Override
  @PutMapping(value= "/",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public PersonDTO update(@RequestBody PersonDTO person) {
    return service.update(person);
  }

  @Override
  @DeleteMapping(value= "/{id}")
  public void delete(@PathVariable("id") Long id) {
    service.delete(id);
  }


}

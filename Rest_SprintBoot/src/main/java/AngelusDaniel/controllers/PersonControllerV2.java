package AngelusDaniel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import AngelusDaniel.data.dto.v2.PersonDTOV2;
import AngelusDaniel.services.PersonServices;
import org.springframework.web.bind.annotation.GetMapping;




@RequestMapping("/api/person/v2")
@RestController
public class PersonControllerV2 {

  @Autowired
  private PersonServices service;

    @PostMapping(value = "/",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
  public PersonDTOV2 create(@RequestBody PersonDTOV2 person) {
    return service.createV2(person);
  }


  
  @GetMapping(value="/{id}",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public PersonDTOV2 findById(@PathVariable("id") Long id) {
    var person = service.findByIdV2(id);
    person.setPhoneNumber("+55 (35) 91234-5678");
    person.setLastName(null);
    person.setSensitiveData("12345 Foo Bar");
    return person;
  }

  @PostMapping(value="/",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public List<PersonDTOV2> findAll() {
      
      return service.findAllV2();
  }
  
}

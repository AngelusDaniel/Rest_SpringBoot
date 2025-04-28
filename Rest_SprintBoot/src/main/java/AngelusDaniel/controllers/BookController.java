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

import AngelusDaniel.data.dto.v1.BookDTO;
import AngelusDaniel.model.Book;
import AngelusDaniel.services.BookServices;


import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/book/v1")
public class  BookController {

  @Autowired
  BookServices services;

  @GetMapping(value = "/",
    produces = { MediaType.APPLICATION_JSON_VALUE, 
      MediaType.APPLICATION_XML_VALUE, 
      MediaType.APPLICATION_YAML_VALUE }
    )
  public List<BookDTO> findAll() {
    return services.findAll();
  }

  @GetMapping(value="/{id}",
    produces = {MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE,
                MediaType.APPLICATION_YAML_VALUE})
  public BookDTO findById(@PathVariable("id") Long id){
    return services.findById(id);
  }

  @PostMapping(value="/",
    produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_YAML_VALUE},
    consumes=MediaType.APPLICATION_JSON_VALUE)
  public BookDTO create(@RequestBody BookDTO book){
    return services.create(book);
  }

  @PutMapping(value="/",
    produces = {MediaType.APPLICATION_JSON_VALUE,
              MediaType.APPLICATION_XML_VALUE,
              MediaType.APPLICATION_YAML_VALUE},
    consumes = MediaType.APPLICATION_JSON_VALUE)
  public BookDTO update(@RequestBody BookDTO book){
    return services.update(book);
  }

  @DeleteMapping(value="/{id}", 
    produces = {MediaType.APPLICATION_JSON_VALUE})
  public BookDTO delete(@PathVariable("id") Long id){
    return services.delete(id);
  }


}

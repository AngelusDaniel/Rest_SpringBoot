package AngelusDaniel.services;

import static AngelusDaniel.mapper.ObjectMapper.parseListObject;
import static AngelusDaniel.mapper.ObjectMapper.parseObject;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AngelusDaniel.controllers.BookController;
import AngelusDaniel.data.dto.v1.BookDTO;
import AngelusDaniel.exception.RequiredObjectIsNullException;
import AngelusDaniel.exception.ResourceNotFoundException;
import AngelusDaniel.model.Book;
import AngelusDaniel.repository.BookRepository;

@Service
public class BookServices {

  @Autowired
  BookRepository repository;

  private Logger logger = Logger.getLogger(BookServices.class.getName());

  public List<BookDTO> findAll(){
    logger.info("Finding all books!");

    var dto =  parseListObject(repository.findAll(), BookDTO.class);
    dto.forEach(dtovar -> addHateoasLinks(dtovar));
    return dto;
  }

  public BookDTO findById(Long id){
    logger.info("Finding one book!");

    var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found!"));
    var dto = parseObject(entity, BookDTO.class);
    addHateoasLinks(dto);
    return dto;
  }

  public BookDTO create(BookDTO book){
    if(book== null) throw new RequiredObjectIsNullException();
    logger.info("Creating one book!");
    var entity = parseObject(book, Book.class);
    var dto = parseObject(repository.save(entity), BookDTO.class);
    addHateoasLinks(dto);
    return dto;
  }

  public BookDTO update(BookDTO book){
    logger.info("Updating one book!");

    var entity = repository.findById(book.getId()).orElseThrow(() -> new ResourceNotFoundException("Book not found!"));
    var dto = parseObject(repository.save(parseObject(book, Book.class)), BookDTO.class);
    addHateoasLinks(dto);
    return dto;
  }

  public BookDTO delete(Long id){
    logger.info("Deleting one book!");

    var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found!"));
    repository.delete(entity);
    var dto = parseObject(entity, BookDTO.class);
    addHateoasLinks(dto);
    return dto;
  }


    private void addHateoasLinks(BookDTO dto) {
 
    dto.add(linkTo(methodOn(BookController.class).findById(dto.getId())).withSelfRel().withType("GET"));
    dto.add(linkTo(BookController.class).slash(dto.getId()).withRel("delete").withType("DELETE"));
    dto.add(linkTo(methodOn(BookController.class).findAll()).withRel("findAll").withType("GET"));
    dto.add(linkTo(methodOn(BookController.class).create(dto)).withRel("create").withType("POST"));
    dto.add(linkTo(methodOn(BookController.class).update(dto)).withRel("update").withType("PUT"));
  }



}

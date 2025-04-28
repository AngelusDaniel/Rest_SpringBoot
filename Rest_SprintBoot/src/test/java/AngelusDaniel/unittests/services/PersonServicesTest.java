package AngelusDaniel.unittests.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import AngelusDaniel.repository.PersonRepository;
import AngelusDaniel.services.PersonServices;
import AngelusDaniel.unittests.mocks.MockPerson;
import AngelusDaniel.data.dto.v1.PersonDTO;
import AngelusDaniel.exception.RequiredObjectIsNullException;
import AngelusDaniel.mapper.custom.PersonMapper;
import AngelusDaniel.model.Person;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonServicesTest {

  @InjectMocks
  private PersonServices personServices;

  @Mock
  private PersonRepository repository;

  @Mock
  private PersonMapper converter;

  MockPerson input;


  @BeforeEach
  void setUp() {
    input = new MockPerson();
    MockitoAnnotations.openMocks(this);
  }

  
  @Test
  void testFindById() {
    Person person = input.mockEntity(1);
    person.setId(1L);
    when(repository.findById(1L)).thenReturn(Optional.of(person));
    var result = personServices.findById(1L);
    assertNotNull(result);
    assertNotNull(result.getId());
    assertNotNull(result.getLinks());
    assertTrue(result.getLinks().stream()
        .anyMatch(link -> link.getRel().value().equals("self")
          && link.getHref().endsWith("/api/person/v1/"+result.getId())
          && link.getType().equals("GET"))
    );

    assertTrue(result.getLinks().stream()
        .anyMatch(link -> link.getRel().value().equals("findAll")
          && link.getHref().endsWith("/api/person/v1/")
          && link.getType().equals("GET"))
    );

    assertTrue(result.getLinks().stream()
        .anyMatch(link -> link.getRel().value().equals("create")
          && link.getHref().endsWith("/api/person/v1/")
          && link.getType().equals("POST"))
    );

    assertTrue(result.getLinks().stream()
        .anyMatch(link -> link.getRel().value().equals("update")
          && link.getHref().endsWith("/api/person/v1/")
          && link.getType().equals("PUT"))
    );

    assertTrue(result.getLinks().stream()
        .anyMatch(link -> link.getRel().value().equals("delete")
          && link.getHref().endsWith("/api/person/v1/"+result.getId())
          && link.getType().equals("DELETE"))
    );

    assertEquals("First Name Test1", result.getFirstName());
    assertEquals("Last Name Test1", result.getLastName());
    assertEquals("Address Test1", result.getAddress());
    assertEquals("Female", result.getGender());
      
    
  }
  
  @Test
  void testFindByIdNotFound() {
    // TODO: Implement test
  }
  
  @Test
  void testCreate() {
    
    Person person = input.mockEntity(1);
    Person persisted = person;
    persisted.setId(1L);

    PersonDTO dto = input.mockDTO(1);
    when(repository.save(person)).thenReturn(persisted);
    var result = personServices.create(dto);
    assertNotNull(result);
    assertNotNull(result.getId());
    assertNotNull(result.getLinks());
    assertTrue(result.getLinks().stream()
        .anyMatch(link -> link.getRel().value().equals("self")
          && link.getHref().endsWith("/api/person/v1/"+result.getId())
          && link.getType().equals("GET"))
    );

    assertTrue(result.getLinks().stream()
        .anyMatch(link -> link.getRel().value().equals("findAll")
          && link.getHref().endsWith("/api/person/v1/")
          && link.getType().equals("GET"))
    );

    assertTrue(result.getLinks().stream()
        .anyMatch(link -> link.getRel().value().equals("create")
          && link.getHref().endsWith("/api/person/v1/")
          && link.getType().equals("POST"))
    );

    assertTrue(result.getLinks().stream()
        .anyMatch(link -> link.getRel().value().equals("update")
          && link.getHref().endsWith("/api/person/v1/")
          && link.getType().equals("PUT"))
    );

    assertTrue(result.getLinks().stream()
        .anyMatch(link -> link.getRel().value().equals("delete")
          && link.getHref().endsWith("/api/person/v1/"+result.getId())
          && link.getType().equals("DELETE"))
    );

    assertEquals("First Name Test1", result.getFirstName());
    assertEquals("Last Name Test1", result.getLastName());
    assertEquals("Address Test1", result.getAddress());
    assertEquals("Female", result.getGender());

  }

  @Test
  void testCreateWithNullPerson() {

    Exception exception = assertThrows(
      RequiredObjectIsNullException.class, 
      ()->{
        personServices.create(null);
      }
    );

    String expectedMessage = "It is not allowed to persist a null object!";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));

  }
  
  @Test
  void testUpdate() {
    Person person = input.mockEntity(1);
    Person persisted = person;
    persisted.setId(1L);
    PersonDTO dto = input.mockDTO(1);
    when(repository.findById(1L)).thenReturn(Optional.of(person));
    when(repository.save(person)).thenReturn(persisted);
    var result = personServices.update(dto);
    assertNotNull(result);
    assertNotNull(result.getId());
    assertNotNull(result.getLinks());

    assertTrue(result.getLinks().stream()
        .anyMatch(link -> link.getRel().value().equals("self")
          && link.getHref().endsWith("/api/person/v1/"+result.getId())
          && link.getType().equals("GET"))
    );

    assertTrue(result.getLinks().stream()
        .anyMatch(link -> link.getRel().value().equals("findAll")
          && link.getHref().endsWith("/api/person/v1/")
          && link.getType().equals("GET"))
    );

    assertTrue(result.getLinks().stream()
        .anyMatch(link -> link.getRel().value().equals("create")
          && link.getHref().endsWith("/api/person/v1/")
          && link.getType().equals("POST"))
    );

    assertTrue(result.getLinks().stream()
        .anyMatch(link -> link.getRel().value().equals("update")
          && link.getHref().endsWith("/api/person/v1/")
          && link.getType().equals("PUT"))
    );

    assertTrue(result.getLinks().stream()
        .anyMatch(link -> link.getRel().value().equals("delete")
          && link.getHref().endsWith("/api/person/v1/"+result.getId())
          && link.getType().equals("DELETE"))
    );

    assertEquals("First Name Test1", result.getFirstName());
    assertEquals("Last Name Test1", result.getLastName());
    assertEquals("Address Test1", result.getAddress());
    assertEquals("Female", result.getGender());
  }

  @Test
  void testUpdateWithNullPerson() {

    Exception exception = assertThrows(
      RequiredObjectIsNullException.class, 
      ()->{
        personServices.update(null);
      }
    );

    String expectedMessage = "It is not allowed to persist a null object!";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));

  }
  
  @Test
  void testUpdateNotFound() {
    // TODO: Implement test
  }
  
  @Test
  void testDelete() {
    Person person = input.mockEntity(1);
    person.setId(1L);
    when(repository.findById(1L)).thenReturn(Optional.of(person));
    personServices.delete(1L);

    verify(repository, times(1)).findById(1L);
    verify(repository, times(1)).delete(person);
    verifyNoMoreInteractions(repository);
    
  }
  
  @Test
  void testDeleteNotFound() {
    // TODO: Implement test
  }

  @Test
  void testFindAll() {
    List<Person> list = input.mockEntityList();
    when(repository.findAll()).thenReturn(list);
    List<PersonDTO> people = personServices.findAll();

    assertNotNull(people);
    assertEquals(14, people.size());

    var personOne = people.get(1);

    assertNotNull(personOne);
    assertNotNull(personOne.getId());
    assertNotNull(personOne.getLinks());

    assertTrue(personOne.getLinks().stream()
        .anyMatch(link -> link.getRel().value().equals("self")
          && link.getHref().endsWith("/api/person/v1/"+personOne.getId())
          && link.getType().equals("GET"))
    );

    assertTrue(personOne.getLinks().stream()
        .anyMatch(link -> link.getRel().value().equals("findAll")
          && link.getHref().endsWith("/api/person/v1/")
          && link.getType().equals("GET"))
    );

    assertTrue(personOne.getLinks().stream()
        .anyMatch(link -> link.getRel().value().equals("create")
          && link.getHref().endsWith("/api/person/v1/")
          && link.getType().equals("POST"))
    );

    assertTrue(personOne.getLinks().stream()
        .anyMatch(link -> link.getRel().value().equals("update")
          && link.getHref().endsWith("/api/person/v1/")
          && link.getType().equals("PUT"))
    );

    assertTrue(personOne.getLinks().stream()
        .anyMatch(link -> link.getRel().value().equals("delete")
          && link.getHref().endsWith("/api/person/v1/"+personOne.getId())
          && link.getType().equals("DELETE"))
    );

    assertEquals("First Name Test1", personOne.getFirstName());
    assertEquals("Last Name Test1", personOne.getLastName());
    assertEquals("Address Test1", personOne.getAddress());
    assertEquals("Female", personOne.getGender());


    // Test for another person in the list

    var personFour = people.get(4);

    assertNotNull(personFour);
    assertNotNull(personFour.getId());
    assertNotNull(personFour.getLinks());

    assertTrue(personFour.getLinks().stream()
        .anyMatch(link -> link.getRel().value().equals("self")
          && link.getHref().endsWith("/api/person/v1/"+personFour.getId())
          && link.getType().equals("GET"))
    );

    assertTrue(personFour.getLinks().stream()
        .anyMatch(link -> link.getRel().value().equals("findAll")
          && link.getHref().endsWith("/api/person/v1/")
          && link.getType().equals("GET"))
    );

    assertTrue(personFour.getLinks().stream()
        .anyMatch(link -> link.getRel().value().equals("create")
          && link.getHref().endsWith("/api/person/v1/")
          && link.getType().equals("POST"))
    );

    assertTrue(personFour.getLinks().stream()
        .anyMatch(link -> link.getRel().value().equals("update")
          && link.getHref().endsWith("/api/person/v1/")
          && link.getType().equals("PUT"))
    );

    assertTrue(personFour.getLinks().stream()
        .anyMatch(link -> link.getRel().value().equals("delete")
          && link.getHref().endsWith("/api/person/v1/"+personFour.getId())
          && link.getType().equals("DELETE"))
    );

    assertEquals("First Name Test4", personFour.getFirstName());
    assertEquals("Last Name Test4", personFour.getLastName());
    assertEquals("Address Test4", personFour.getAddress());
    assertEquals("Male", personFour.getGender());





    var personNine = people.get(9);

    assertNotNull(personNine);
    assertNotNull(personNine.getId());
    assertNotNull(personNine.getLinks());

    assertTrue(personNine.getLinks().stream()
        .anyMatch(link -> link.getRel().value().equals("self")
          && link.getHref().endsWith("/api/person/v1/"+personNine.getId())
          && link.getType().equals("GET"))
    );

    assertTrue(personNine.getLinks().stream()
        .anyMatch(link -> link.getRel().value().equals("findAll")
          && link.getHref().endsWith("/api/person/v1/")
          && link.getType().equals("GET"))
    );

    assertTrue(personNine.getLinks().stream()
        .anyMatch(link -> link.getRel().value().equals("create")
          && link.getHref().endsWith("/api/person/v1/")
          && link.getType().equals("POST"))
    );

    assertTrue(personNine.getLinks().stream()
        .anyMatch(link -> link.getRel().value().equals("update")
          && link.getHref().endsWith("/api/person/v1/")
          && link.getType().equals("PUT"))
    );

    assertTrue(personNine.getLinks().stream()
        .anyMatch(link -> link.getRel().value().equals("delete")
          && link.getHref().endsWith("/api/person/v1/"+personNine.getId())
          && link.getType().equals("DELETE"))
    );

    assertEquals("First Name Test9", personNine.getFirstName());
    assertEquals("Last Name Test9", personNine.getLastName());
    assertEquals("Address Test9", personNine.getAddress());
    assertEquals("Female", personNine.getGender());

  }




  
}

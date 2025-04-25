package AngelusDaniel.mapper.custom;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import AngelusDaniel.data.dto.v2.PersonDTOV2;
import AngelusDaniel.model.Person;

@Service
public class PersonMapper {

    public PersonDTOV2 convertEntityToDTO(Person person) {
        PersonDTOV2 dto = new PersonDTOV2();
        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setBirthDate(person.getBirthDate());
        dto.setAddress(person.getAddress());
        dto.setGender(person.getGender());
        return dto;
    }

    public Person convertDTOToEntity(PersonDTOV2 person) {
        Person entity = new Person();
        entity.setId(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setBirthDate(person.getBirthDate());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return entity;
    }

    //list
    public List<PersonDTOV2> convertEntityListToDTOList(List<Person> persons) {
        List<PersonDTOV2> dtos = new ArrayList<>();
        for (Person person : persons) {
            dtos.add(convertEntityToDTO(person));
        }
        return dtos;
    }
    public List<Person> convertDTOListToEntityList(List<PersonDTOV2> persons) {
        List<Person> entities = new ArrayList<>();
        for (PersonDTOV2 person : persons) {
            entities.add(convertDTOToEntity(person));
        }
        return entities;
    }

}

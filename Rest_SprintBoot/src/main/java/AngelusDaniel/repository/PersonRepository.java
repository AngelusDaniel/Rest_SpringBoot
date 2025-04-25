package AngelusDaniel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import AngelusDaniel.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
  // This interface will automatically provide CRUD operations for the Person entity
  // No need to implement any methods, JpaRepository handles it for us
}

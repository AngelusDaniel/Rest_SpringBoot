package AngelusDaniel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import AngelusDaniel.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
  
}

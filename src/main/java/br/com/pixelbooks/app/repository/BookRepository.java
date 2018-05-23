package br.com.pixelbooks.app.repository;

import br.com.pixelbooks.app.entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long>{

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Book save(Book book);
}

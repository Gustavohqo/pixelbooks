package br.com.pixelbooks.app.repository;

import br.com.pixelbooks.app.entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long>{

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> findByIsbn(String isbn);

    List<Book> findByTitle(String title);

    List<Book> findBooksByTitleOrAuthorOrIsbn(String title, String author, String isbn);

    List<Book> findByAuthor(String author);

    Book save(Book book);
}

package br.com.pixelbooks.app.repository;

import br.com.pixelbooks.app.entity.Book;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> findByIsbn(String isbn);

    List<Book> findByTitle(String title);

    @Query("select b from Book b where lower(b.title) like concat('%', lower(?1), '%')" +
            "or lower(b.author) like concat('%', lower(?1), '%')" +
            "or b.isbn = ?1")
    List<Book> findAllBooksContainingKeyword(String keyword);

    List<Book> findByAuthor(String author);

    Book save(Book book);
}

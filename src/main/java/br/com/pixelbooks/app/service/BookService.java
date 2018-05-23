package br.com.pixelbooks.app.service;

import br.com.pixelbooks.app.entity.Book;
import br.com.pixelbooks.app.repository.BookRepositoryMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepositoryMock bookRepositoryMock;


    public List<Book> findBooks() {
        return bookRepositoryMock.findAll();
    }

    public Book findBook(Long id) {
        return bookRepositoryMock.findById(id);
    }

    public Book saveBook(Book book) {
        return bookRepositoryMock.save(book);
    }
}

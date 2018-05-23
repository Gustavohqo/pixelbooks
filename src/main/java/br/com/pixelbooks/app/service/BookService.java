package br.com.pixelbooks.app.service;

import br.com.pixelbooks.app.entity.Book;
import br.com.pixelbooks.app.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;


    public List<Book> findBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> findBook(Long id) {
        return bookRepository.findById(id);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
}

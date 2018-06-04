package br.com.pixelbooks.app.service;

import br.com.pixelbooks.app.dto.ItemDTO;
import br.com.pixelbooks.app.entity.Book;
import br.com.pixelbooks.app.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AWSService awsService;

    public List<Book> findBooks() throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        List<ItemDTO> itemsFound = awsService.searchBookByTitle("black hammer");

        List<Book> books = this.itemsToBooks(itemsFound);
        books.addAll(bookRepository.findAll());
        return books;
    }

    public Optional<Book> findBook(Long id) {
        return bookRepository.findById(id);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }


    private List<Book> itemsToBooks(List<ItemDTO> items) {
        List<Book> books = new ArrayList<>();
        for(ItemDTO item : items) {
            books.add(new Book(item));
        }

        return books;
    }
}

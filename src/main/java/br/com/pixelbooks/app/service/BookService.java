package br.com.pixelbooks.app.service;

import br.com.pixelbooks.app.dto.awsDTO.ItemDTO;
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

    public List<Book> findBooks() { return bookRepository.findAll(); }

    public Optional<Book> findBook(Long id) {
        return bookRepository.findById(id);
    }

    public List<Book> findBookByTitle(String title) {
        List<ItemDTO> itemsFound = awsService.searchBookByTitle(title);
        List<Book> books = this.itemsToBooks(itemsFound);
        books.addAll(bookRepository.findByTitle(title));

        return books;
    }


    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    /**
     * Transform a List of {@link ItemDTO} to a List of {@link Book}
     *
     * @param items the list of {@link ItemDTO} to be transformed.
     * @return a List of {@link Book} that corresponding to the list received.
     */
    private List<Book> itemsToBooks(List<ItemDTO> items) {
        List<Book> books = new ArrayList<>();
        for(ItemDTO item : items) {
            books.add(new Book(item));
        }

        return books;
    }
}

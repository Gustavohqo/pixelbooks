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

    /**
     * It seeks by a book using a keyword that must be the Title, Author or
     * ISBN number.
     *
     * @param keyword as a {@link String} thaa will be searched
     * @return {@link List<Book>} containing the books found. It can be empty
     *          if no book be found.
     */
    public List<Book> findBookByKeyword(String keyword) {
        List<ItemDTO> itemsFound = awsService.searchBookByTitle(keyword);
        List<Book> books = this.itemsToBooks(itemsFound);
        books.addAll(bookRepository.findBooksByTitleOrAuthorOrIsbn(keyword));

        return books;
    }


    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    /**
     * Transform a {@link List<ItemDTO>} to a {@link List<Book>}
     *
     * @param items the @link List<ItemDTO>} to be transformed.
     * @return a {@link List<Book>} that corresponding to the list received.
     */
    private List<Book> itemsToBooks(List<ItemDTO> items) {
        List<Book> books = new ArrayList<>();
        for(ItemDTO item : items) {
            books.add(new Book(item));
        }

        return books;
    }
}

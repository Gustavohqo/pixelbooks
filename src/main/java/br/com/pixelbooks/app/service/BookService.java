package br.com.pixelbooks.app.service;

import br.com.pixelbooks.app.dto.awsDTO.ItemDTO;
import br.com.pixelbooks.app.entity.Book;
import br.com.pixelbooks.app.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Optional<Book> findBookByIsbn(String isbn) { return bookRepository.findByIsbn(isbn); }

    /**
     * It seeks by a book using a keyword that must be the Title, Author or
     * ISBN number. It can search at Amazon Advertise Product API, but only if
     * no book was found at BD OR if explicitly said so.
     *
     * @param keyword as a {@link String} that will be searched.
     * @param loadMore as a {@link Boolean} that allows AAPAPI be called.
     * @return {@link List<Book>} containing the books found. It can be empty
     *          if no book be found.
     */
    public List<Book> findBookByKeyword(String keyword, Boolean loadMore) {
        List<Book> books = bookRepository.findAllBooksContainingKeyword(keyword);

        if(books.isEmpty() || loadMore) {
            List<ItemDTO> itemsFound = awsService.searchBookByTitle(keyword);
            List<Book> allBooksFind = this.itemsToBooks(itemsFound);
            books.addAll(allBooksFind);
        }
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

        if (items != null) {
            for(ItemDTO item : items) {
                books.add(new Book(item));
            }
        }

        return books;
    }
}

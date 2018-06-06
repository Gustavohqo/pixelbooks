package br.com.pixelbooks.app.controller;

import br.com.pixelbooks.app.entity.Book;
import br.com.pixelbooks.app.service.AWSService;
import br.com.pixelbooks.app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Book> getBooks() {
        return bookService.findBooks();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Book> getBook(@PathVariable("id") Long id) {
        return bookService.findBook(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<Book> getBookByTitle(@RequestParam("title") String title) {
        return bookService.findBookByTitle(title);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<Book> getBookByISBN(@RequestParam("isbn") String isbn) {
        return bookService.findBookByTitle(isbn);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<Book> getBookByAuthor(@RequestParam("author") String author) {
        return bookService.findBookByTitle(author);
    }

    @RequestMapping(value = "", headers="Content-Type=application/json", method = RequestMethod.POST)
    @ResponseBody
    public Book save(@RequestBody Book book) {
        return bookService.saveBook(book);
    }
}

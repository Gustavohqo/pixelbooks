package br.com.pixelbooks.app.controller;

import br.com.pixelbooks.app.entity.Book;
import br.com.pixelbooks.app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Book>getBooks() {
        return bookService.findBooks();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book getBook(@PathVariable("id") Long id) {
        return bookService.findBook(id);
    }

    @RequestMapping(value = "/", headers="Content-Type=application/json", method = RequestMethod.POST)
    @ResponseBody
    public Book save(@RequestBody Book book) {
        return bookService.saveBook(book);
    }
}

package br.com.pixelbooks.app.controller;

import br.com.pixelbooks.app.entity.Book;
import br.com.pixelbooks.app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Book> searchBooks(@RequestParam String search, @RequestParam(required = false, defaultValue = "false") Boolean loadMore) {
        return bookService.findBookByKeyword(search, loadMore);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Book> getBook(@PathVariable("id") Long id) {
        return bookService.findBookById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Book save(@RequestBody Book book) {
        return bookService.saveBook(book);
    }
}

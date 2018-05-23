package br.com.pixelbooks.app.repository;


import br.com.pixelbooks.app.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class BookRepositoryMock {

    private List<Book> books = Arrays.asList(
            new Book(1L,"Kindle Unlimited", "Amazon", "https://www.amazon.com.br/kindle-dbs/hz/signup/ref=as_li_ss_tl?_encoding=UTF8&ref_=pe_1613460_282773570&linkCode=ll2&tag=pixelbooks03-20&linkId=8d8fa1590abfc265ee3f3edc5ba8957d"),
            new Book(2L, "O Olho do Mundo", "Robert Jordan", "https://www.amazon.com.br/Olho-Mundo-Livro-roda-tempo/dp/8580573610/ref=as_li_ss_tl?_encoding=UTF8&qid=1524508308&sr=1-1&linkCode=ll1&tag=pixelbooks03-20&linkId=21fb813964819c38962e094411cd59a7"));

    public List<Book> findAll() {
      return books;
    }

    public Book findById(Long id) {
        for(Book book : books){
            if (book.getId().equals(id)) {
                return book;
            }
        }

        return null;
    }

    public Book save(Book book) {
        books.add(book);
        return book;
    }
}

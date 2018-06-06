package br.com.pixelbooks.app.entity;

import br.com.pixelbooks.app.dto.awsDTO.ItemDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Class that defines Book Entity
 */
@Entity
public class Book implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column
    private String link;

    @Column
    private Integer numberOfPages;

    @Column(unique = true, nullable = false)
    private String isbn;

    @Column
    private String publisher;

    @Column
    private String releaseDate;

    public Book() {}

    public Book(ItemDTO itemDTO) {
        this.setAuthor(itemDTO.getAuthor());
        this.setTitle(itemDTO.getTitle());
        this.setLink(itemDTO.getUrl());
        this.setNumberOfPages(itemDTO.getNumberOfPages());
        this.setIsbn(itemDTO.getIsbn());
        this.setPublisher(itemDTO.getPublisher());
        this.setReleaseDate(itemDTO.getReleaseDate());
    }

    public Book(String title, String author, String link, String isbn) {
        this.title = title;
        this.author = author;
        this.link = link;
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}

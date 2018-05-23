package br.com.pixelbooks.app.entity;

import javax.persistence.Entity;

/**
 * Class that defines Book Entity
 */
//@Entity
public class Book {

    private Long id;

    private String name;

    private String author;

    private String link;

    public Book(Long id, String name, String author, String link) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.link = link;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}

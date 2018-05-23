package br.com.pixelbooks.app.entity;

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

    @Column
    private String name;

    @Column
    private String author;

    @Column
    private String link;

    public Book() {}

    public Book(String name, String author, String link) {
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

package br.com.pixelbooks.app.entity;

import br.com.pixelbooks.app.dto.ItemDTO;

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
    private String title;

    @Column
    private String author;

    @Column
    private String link;

    public Book() {}

    public Book(ItemDTO itemDTO) {
        this.setAuthor(itemDTO.getItemAttributesDTO().getAuthor());
        this.setTitle(itemDTO.getItemAttributesDTO().getTitle());
        this.setLink(itemDTO.getUrl());
    }

    public Book(String title, String author, String link) {
        this.title = title;
        this.author = author;
        this.link = link;
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
}

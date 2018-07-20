package br.com.pixelbooks.app.dto.awsDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Describes an Amazon Item, these attributes are relevant data about
 * books.
 */
@XmlAccessorType(XmlAccessType.NONE)
public class ItemAttributesDTO {

    @XmlElement(name = "Author", namespace="http://webservices.amazon.com/AWSECommerceService/2011-08-01")
    private String author;

    @XmlElement(name = "ISBN", namespace="http://webservices.amazon.com/AWSECommerceService/2011-08-01")
    private String isbn;

    @XmlElement(name = "NumberOfPages", namespace="http://webservices.amazon.com/AWSECommerceService/2011-08-01")
    private Integer numberOfPages;

    @XmlElement(name = "Publisher", namespace="http://webservices.amazon.com/AWSECommerceService/2011-08-01")
    private String publisher;

    @XmlElement(name = "Title", namespace="http://webservices.amazon.com/AWSECommerceService/2011-08-01")
    private String title;

    @XmlElement(name = "ReleaseDate", namespace="http://webservices.amazon.com/AWSECommerceService/2011-08-01")
    private String releaseDate;

    public ItemAttributesDTO() { }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "ItemAttributesDTO{" +
                "author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", publisher='" + publisher + '\'' +
                ", title='" + title + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}

package br.com.pixelbooks.app.dto.awsDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Class that maps an Amazon Item, this Item in specific
 * has attributes of a book.
 */
@XmlAccessorType(XmlAccessType.NONE)
public class ItemDTO {

    @XmlElement(name = "ASIN", namespace="http://webservices.amazon.com/AWSECommerceService/2011-08-01")
    private String asin;

    @XmlElement(name = "DetailPageURL", namespace="http://webservices.amazon.com/AWSECommerceService/2011-08-01")
    private String url;

    @XmlElement(name = "ItemAttributes", namespace="http://webservices.amazon.com/AWSECommerceService/2011-08-01")
    private ItemAttributesDTO itemAttributesDTO;

    public ItemDTO() {}

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ItemAttributesDTO getItemAttributesDTO() {
        return itemAttributesDTO;
    }

    public void setItemAttributesDTO(ItemAttributesDTO itemAttributesDTO) {
        this.itemAttributesDTO = itemAttributesDTO;
    }

    public String getAuthor() { return itemAttributesDTO.getAuthor(); }

    public String getIsbn() { return itemAttributesDTO.getIsbn(); }

    public String getPublisher() { return itemAttributesDTO.getPublisher(); }

    public String getTitle() { return itemAttributesDTO.getTitle(); }

    public Integer getNumberOfPages() { return itemAttributesDTO.getNumberOfPages(); }

    public String getReleaseDate() { return itemAttributesDTO.getReleaseDate(); }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "asin='" + asin + '\'' +
                ", url='" + url + '\'' +
                ", itemAttributesDTO=" + itemAttributesDTO +
                '}';
    }
}

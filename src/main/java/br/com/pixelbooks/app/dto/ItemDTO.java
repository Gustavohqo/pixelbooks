package br.com.pixelbooks.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
public class ItemDTO {

    @XmlElement(name = "ASIN")
    private String asin;

    @XmlElement(name = "DetailPageURL")
    private String url;

    @XmlElement(name = "ItemAttributes")
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

    @Override
    public String toString() {
        return "ItemDTO{" +
                "asin='" + asin + '\'' +
                ", url='" + url + '\'' +
                ", itemAttributesDTO=" + itemAttributesDTO +
                '}';
    }
}

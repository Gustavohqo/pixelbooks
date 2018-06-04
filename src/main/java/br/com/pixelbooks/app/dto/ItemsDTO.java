package br.com.pixelbooks.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

@XmlAccessorType(XmlAccessType.NONE)
public class ItemsDTO {

    @XmlElement(name = "TotalResults")
    private Integer totalResults;

    @XmlElement(name = "Item")
    private List<ItemDTO> item;

    public ItemsDTO() {}

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public List<ItemDTO> getItem() {
        return item;
    }

    public void setItem(List<ItemDTO> item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "ItemsDTO{" +
                "totalResults=" + totalResults +
                ", item=" + item +
                '}';
    }
}

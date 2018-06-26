package br.com.pixelbooks.app.dto.awsDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Class that maps the collection of Amazon Items. It should be returned from
 * Search request and have pagination data.
 */
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

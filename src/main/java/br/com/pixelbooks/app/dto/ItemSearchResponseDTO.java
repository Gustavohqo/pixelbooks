package br.com.pixelbooks.app.dto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name="ItemSearchResponse", namespace="http://webservices.amazon.com/AWSECommerceService/2011-08-01" )
@XmlAccessorType(XmlAccessType.NONE)
public class ItemSearchResponseDTO {

    @XmlElement(name = "Items")
    private ItemsDTO itemsDTO;

    public ItemSearchResponseDTO() { }

    public ItemsDTO getItemsDTO() {
        return itemsDTO;
    }

    public void setItemsDTO(ItemsDTO itemsDTO) {
        this.itemsDTO = itemsDTO;
    }

    @Override
    public String toString() {
        return "ItemSearchResponseDTO{" +
                "itemsDTO=" + itemsDTO +
                '}';
    }
}

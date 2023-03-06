package com.example.supermarketstore.data;

import com.example.supermarketstore.domain.Store;
import com.example.supermarketstore.domain.Supermarket;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class SupermarketData {

//    @JsonProperty("id")
//    private Long id;


//    private Long itemId;

    @JsonProperty("dateReceived")
    private Date dateReceived;

    @JsonProperty("price")
    private Double price;

//    private String itemName;

    public static Supermarket map(SupermarketData data){
        Supermarket supermarket = new Supermarket();
        supermarket.setDateReceived(data.getDateReceived());
        return supermarket;
    }

    public static SupermarketData map(Supermarket supermarket){
        SupermarketData supermarketData = new SupermarketData();
       // supermarketData.setId(supermarket.getId());
//        supermarketData.setItemId(supermarket.getStore().getId());
        supermarketData.setDateReceived(supermarket.getDateReceived());
        supermarketData.setPrice(supermarket.getPrice());
        return supermarketData;
    }



}

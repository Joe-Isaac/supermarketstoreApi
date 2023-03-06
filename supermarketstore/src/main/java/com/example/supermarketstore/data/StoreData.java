package com.example.supermarketstore.data;

import com.example.supermarketstore.domain.Store;
import com.example.supermarketstore.domain.Vendor;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class StoreData {

    @JsonProperty("id")
    private Long Id;

    @JsonProperty("itemName")
    private String itemName;

    @JsonProperty("dateProcured")
    private Date dateProcured;

    @JsonProperty("vendorId")
    private Long vendorId;

    @JsonProperty("status")
    private String status;

    public static Store map(StoreData data){
        Store store = new Store();
        store.setItemName(data.getItemName());
        store.setDateProcured(data.getDateProcured());
        store.setStatus(data.getStatus());
        return store;
    }

    public static StoreData map(Store store){
        StoreData data = new StoreData();
        data.setId(store.getId());
        data.setItemName(store.getItemName());
        data.setDateProcured(store.getDateProcured());
        data.setVendorId(store.getVendor().getId());
        data.setStatus(store.getStatus());
        return data;
    }

}

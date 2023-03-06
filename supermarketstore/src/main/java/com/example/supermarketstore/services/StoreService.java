package com.example.supermarketstore.services;

import com.example.supermarketstore.data.ItemsReturnedData;
import com.example.supermarketstore.data.StoreData;
import com.example.supermarketstore.data.SupermarketData;
import com.example.supermarketstore.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class StoreService {
    private final StoreRepository repository;
    private final VendorService vendorService;

    private final ItemsReturnedRepository itemsReturnedRepository;

    private final SupermaketRepository supermarketRepository;

    // CREATE
    public StoreData createItem(StoreData data){
        Store store = StoreData.map(data);
        if(data.getVendorId() !=null){
            store.setVendor(vendorService.getVendorById(data.getVendorId()));
        }

        return StoreData.map(repository.save(store));
    }

    // GET
    public List<StoreData> getItems(){
            List<StoreData> response = new ArrayList<>();
            repository.findAll().forEach(item -> {
                response.add(StoreData.map(item));
            } );
            return response;
    }

    // GET BY ID
    public StoreData getItemById(Long id){
        return StoreData.map(repository.findById(id).get());
    }

    // UPDATE
    public StoreData updateItem(StoreData data, Long id){
        Store store = repository.findById(id).get();
        store.setItemName(data.getItemName());
        store.setDateProcured(data.getDateProcured());
        if(data.getVendorId() !=null){
            store.setVendor(vendorService.getVendorById(data.getVendorId()));
        }

        return StoreData.map(repository.save(store));
    }


    // DELETE
    public void deleteItem(Long id){
        repository.deleteById(id);
    }

    public Supermarket releaseItem(SupermarketData data, Long id){
        Store item = repository.findById(id).get();
        Supermarket newData = new Supermarket();
        newData.setPrice(data.getPrice());
        newData.setDateReceived(data.getDateReceived());
        newData.setItemName(item.getItemName());

        item.setStatus("supermarket");


        repository.save(item);

        supermarketRepository.save(newData);
        return newData;
    }

    public ItemsReturnedData returnItemsToVendor(ItemsReturnedData data, Long id){

        Store item = repository.findById(id).get();

        ItemsReturned newData = new ItemsReturned();
        newData.setDateReturned(data.getDateReturned());
        newData.setStore(item);
        newData.setVendor(vendorService.getVendorById(item.getVendor().getId()));
        newData.setItemName(item.getItemName());
        item.setStatus("vendor");


        repository.save(item);
        itemsReturnedRepository.save(newData);
        return ItemsReturnedData.map(newData);
    }
}

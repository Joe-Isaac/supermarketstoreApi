package com.example.supermarketstore.services;

import com.example.supermarketstore.data.ItemsReturnedData;
import com.example.supermarketstore.data.StoreData;
import com.example.supermarketstore.data.SupermarketData;
import com.example.supermarketstore.domain.ItemsReturned;
import com.example.supermarketstore.domain.ItemsReturnedRepository;
import com.example.supermarketstore.domain.Store;
import com.example.supermarketstore.domain.Supermarket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ItemsReturnedService {
    private final ItemsReturnedRepository repository;

    private VendorService vendorService;

    private StoreService storeService;

    // CREATE
    public ItemsReturnedData createItemReturned(ItemsReturnedData data){
        ItemsReturned itemsReturned = ItemsReturnedData.map(data);
//        if(data.getVendorId() !=null){
//            itemsReturned.setVendor(vendorService.getVendorById(data.getVendorId()));
//        }
//        if(data.getItemId() != null){
//            itemsReturned.setStore(StoreData.map(storeService.getItemById(data.getItemId())));
//        }

        return ItemsReturnedData.map(repository.save(itemsReturned));
    }

    // GET
    public List<ItemsReturnedData> getItemsReturned(){
        List<ItemsReturnedData> response = new ArrayList<>();
        repository.findAll().forEach(item -> {
            response.add(ItemsReturnedData.map(item));
        } );
        return response;
    }

    // GET BY ID
    public ItemsReturnedData getItemsReturnedById(Long id){
        return ItemsReturnedData.map(repository.findById(id).get());
    }

    // UPDATE
//    public ItemsReturnedData updateItemsReturned(ItemsReturnedData data, Long id){
//        ItemsReturned itemsReturned = repository.findById(id).get();
//        itemsReturned.setDateReturned(data.getDateReturned());
////        if(data.getVendorId() !=null){
////            itemsReturned.setVendor(vendorService.getVendorById(data.getVendorId()));
////        }
////        if(data.getItemId() != null){
////            itemsReturned.setStore(StoreData.map(storeService.getItemById(data.getItemId())));
////        }
////        return ItemsReturnedData.map(repository.save(itemsReturned));
//    }


    // DELETE
    public void deleteItemReturned(Long id){
        repository.deleteById(id);
    }
}

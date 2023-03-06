package com.example.supermarketstore.services;

import com.example.supermarketstore.data.StoreData;
import com.example.supermarketstore.data.SupermarketData;
import com.example.supermarketstore.domain.Store;
import com.example.supermarketstore.domain.SupermaketRepository;
import com.example.supermarketstore.domain.Supermarket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class SupermarketService {
     private final SupermaketRepository repository;




     // CREATE
     public Supermarket createSupermarketItem(Supermarket data) {
         return repository.save(data);
     }

    // GET
    public List<Supermarket> getSupermarketItems(){
       return repository.findAll();

    }

    // GET BY ID
    public Supermarket getSupermarketItemById(Long id){
        return repository.findById(id).get();
    }

    // UPDATE
    public SupermarketData updateItem(SupermarketData data, Long id){
        Supermarket supermarket = repository.findById(id).get();
        supermarket.setPrice(data.getPrice());
        supermarket.setDateReceived(data.getDateReceived());
//        if(data.getItemId() != null) {
//            supermarket.setStore(StoreData.map(storeService.getItemById(data.getItemId())));
//        }
        return SupermarketData.map(repository.save(supermarket));
    }


    // DELETE
    public void deleteSupermarketItem(Long id){
        repository.deleteById(id);
    }
}


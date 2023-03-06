package com.example.supermarketstore.api;

import com.example.supermarketstore.data.ItemsReturnedData;
import com.example.supermarketstore.data.SupermarketData;
import com.example.supermarketstore.domain.Supermarket;
import com.example.supermarketstore.services.SupermarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor

public class SupermarketController {

    private final SupermarketService service;

    // POST
//    public SupermarketData createSupermarketItem(@RequestBody SupermarketData data){
//        return service.createSupermarketItem(data);
//    }

    // FETCH ALL
    @GetMapping("/supermarket_item")
    public @ResponseBody List<Supermarket> fetchSupermarketItems(){
        return service.getSupermarketItems();
    }

    // FETCH BY ID
    @GetMapping("/supermarket_item/{id}")
    public Supermarket getSupermarketItemById(@PathVariable Long id){
        return service.getSupermarketItemById(id);

    }

    // DELETE
    @DeleteMapping("/supermarket_item/{id}")
    public void deleteSupermarketItem(@PathVariable Long id){
        service.deleteSupermarketItem(id);
        LocalDate dew;
        dew.
    }
}

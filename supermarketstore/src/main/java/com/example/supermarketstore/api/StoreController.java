package com.example.supermarketstore.api;

import com.example.supermarketstore.data.ItemsReturnedData;
import com.example.supermarketstore.data.StoreData;
import com.example.supermarketstore.data.SupermarketData;
import com.example.supermarketstore.domain.Supermarket;
import com.example.supermarketstore.services.ItemsReturnedService;
import com.example.supermarketstore.services.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class StoreController {

    private final StoreService storeService;

    private final ItemsReturnedService itemsReturnedService;

    // POST
    @PostMapping("/store")
    public StoreData createItem(@RequestBody StoreData data){
        return storeService.createItem(data);
    }

    // FETCH ALL
    @GetMapping("/store")
    public @ResponseBody List<StoreData> fetchStoreData(){
        return storeService.getItems();
    }

    // FETCH ID
    @GetMapping("/store/{id}")
    public StoreData getItemById(@PathVariable Long id){
        return storeService.getItemById(id);

    }

    // DELETE
    @DeleteMapping("/store/{id}")
    public void deleteItem(@PathVariable Long id){
        storeService.deleteItem(id);
    }

    @PutMapping("/releaseFromStore/{id}")
    public ResponseEntity<?> releaseItem(
            @RequestBody SupermarketData data,
            @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(storeService.releaseItem(data, id));
    }

    @PutMapping("/returnToVendor/{id}")
    public ResponseEntity<?> releaseItemToVendor(
            @RequestBody ItemsReturnedData data,
            @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(storeService.returnItemsToVendor(data, id));
    }
}

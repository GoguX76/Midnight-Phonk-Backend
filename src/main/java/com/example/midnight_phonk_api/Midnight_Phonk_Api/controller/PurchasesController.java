package com.example.midnight_phonk_api.Midnight_Phonk_Api.controller;

import com.example.midnight_phonk_api.Midnight_Phonk_Api.model.Purchases;
import com.example.midnight_phonk_api.Midnight_Phonk_Api.repository.PurchasesRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchases")
public class PurchasesController {

    @Autowired
    private PurchasesRepository purchasesRepository;

    @GetMapping
    public ResponseEntity<List<Purchases>> getAllPurchases() {
        List<Purchases> purchases = purchasesRepository.findAll();
        return ResponseEntity.ok(purchases);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Purchases> getPurchaseById(@PathVariable Long id) {
        return purchasesRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Purchases> createPurchase(@Valid @RequestBody Purchases purchase) {
        Purchases savedPurchase = purchasesRepository.save(purchase);
        return ResponseEntity.ok(savedPurchase);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchase(@PathVariable Long id) {
        return purchasesRepository.findById(id)
                .map(purchase -> {
                    purchasesRepository.delete(purchase);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

package com.example.midnight_phonk_api.Midnight_Phonk_Api.service;

import com.example.midnight_phonk_api.Midnight_Phonk_Api.model.Products;
import com.example.midnight_phonk_api.Midnight_Phonk_Api.model.Purchases;
import com.example.midnight_phonk_api.Midnight_Phonk_Api.model.Users;
import com.example.midnight_phonk_api.Midnight_Phonk_Api.repository.ProductRepository;
import com.example.midnight_phonk_api.Midnight_Phonk_Api.repository.PurchasesRepository;
import com.example.midnight_phonk_api.Midnight_Phonk_Api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchasesService {

    @Autowired
    private PurchasesRepository purchasesRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Purchases> getAllPurchases() {
        return purchasesRepository.findAll();
    }

    public Optional<Purchases> getPurchaseById(Long id) {
        return purchasesRepository.findById(id);
    }

    public List<Purchases> getPurchasesByUserId(Long userId) {
        return purchasesRepository.findByUserId(userId);
    }

    public List<Purchases> getPurchasesByProductId(Long productId) {
        return purchasesRepository.findByProductId(productId);
    }

    public List<Purchases> createPurchase(
            com.example.midnight_phonk_api.Midnight_Phonk_Api.dto.PurchaseRequest request) {
        Users user = userRepository.findByEmail(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with email: " + request.getUserId()));

        String shippingDetailsJson = "";
        try {
            shippingDetailsJson = new com.fasterxml.jackson.databind.ObjectMapper()
                    .writeValueAsString(request.getShippingDetails());
        } catch (Exception e) {
            shippingDetailsJson = String.valueOf(request.getShippingDetails());
        }

        String finalShippingDetails = shippingDetailsJson;

        return request.getItems().stream().map(item -> {
            Products product = productRepository.findById(item.getId())
                    .orElseThrow(() -> new RuntimeException("Product not found: " + item.getId()));

            Double totalPrice = product.getPrice() * item.getQuantity();

            Purchases purchase = Purchases.builder()
                    .user(user)
                    .product(product)
                    .quantity(item.getQuantity())
                    .totalPrice(totalPrice)
                    .shippingDetails(finalShippingDetails)
                    .build();

            return purchasesRepository.save(purchase);
        }).collect(java.util.stream.Collectors.toList());
    }

    public void deletePurchase(Long id) {
        purchasesRepository.deleteById(id);
    }
}

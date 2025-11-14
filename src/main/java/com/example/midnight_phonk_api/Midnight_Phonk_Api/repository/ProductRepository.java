package com.example.midnight_phonk_api.Midnight_Phonk_Api.repository;

import com.example.midnight_phonk_api.Midnight_Phonk_Api.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
}

package com.example.midnight_phonk_api.Midnight_Phonk_Api.repository;

import com.example.midnight_phonk_api.Midnight_Phonk_Api.model.Purchases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchasesRepository extends JpaRepository<Purchases, Long> {
}

package com.example.midnight_phonk_api.Midnight_Phonk_Api.repository;

import com.example.midnight_phonk_api.Midnight_Phonk_Api.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    List<Users> findByEmail(String email);
    List<Users> findByEmailAndPassword(String email, String password);
}

package com.example.midnight_phonk_api.Midnight_Phonk_Api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.midnight_phonk_api.Midnight_Phonk_Api.model.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
}

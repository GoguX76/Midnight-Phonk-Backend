package com.example.midnight_phonk_api.Midnight_Phonk_Api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column
    private String title;

    @NotBlank
    @Column
    private String summary;

    @NotBlank
    @Column
    private String description;

    @NotBlank
    @Column
    private String author;

    @Column
    private LocalDateTime updateAt;

    @PrePersist
    protected void onCreate() {
        updateAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updateAt = LocalDateTime.now();
    }
}

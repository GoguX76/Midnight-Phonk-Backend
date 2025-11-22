package com.example.midnight_phonk_api.Midnight_Phonk_Api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNew;

    @NotBlank
    @Column
    private String titleNew;

    @Column(columnDefinition = "TEXT")
    private String imageNew;

    @Column
    private String categoryNew;

    @Column
    private String shortDescNew;

    @NotBlank
    @Column
    private String autorNew;

    @Column
    private String dateNew;

    @Column(columnDefinition = "TEXT")
    private String fullDescNew;

    @Builder.Default
    @Column
    private Integer likes = 0;
}

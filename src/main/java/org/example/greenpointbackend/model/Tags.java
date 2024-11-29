package org.example.greenpointbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.greenpointbackend.model.Enums.Brands;
import org.example.greenpointbackend.model.Enums.Title;
import org.example.greenpointbackend.model.Enums.Vision;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Title title; //todo skal laves til liste hvis der skal være flere

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Vision vision;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Brands brands;

}
package org.example.greenpointbackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 2000)
    private String description;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date endDate;
}

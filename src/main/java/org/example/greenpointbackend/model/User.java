package org.example.greenpointbackend.model;


import jakarta.persistence.*;
import lombok.*;
import org.example.greenpointbackend.model.Enums.Role;
import org.example.greenpointbackend.model.Enums.Title;

import java.util.Set;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 50)
    private String username;

    @Column(nullable = false, length = 60)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Title title; //todo skal være liste hvis der skal være flere

    @Column(nullable = false)
    private int storeId;

    @ManyToMany(mappedBy = "users")
    private Set<Course> courses;
}

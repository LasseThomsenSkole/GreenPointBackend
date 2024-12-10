package org.example.greenpointbackend.model;


import jakarta.persistence.*;
import lombok.*;
import org.example.greenpointbackend.model.Enums.Role;
import org.example.greenpointbackend.model.Enums.JobTitle;

import java.util.HashSet;
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
    private String email;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String phoneNumber;

    @Column(nullable = false, length = 60)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private JobTitle jobTitle; //todo skal være liste hvis der skal være flere - det skal det mici

    @Column(nullable = false)
    private int storeId;

    /*@ManyToMany(mappedBy = "users")
    private Set<Course> courses = new HashSet<>(); //hashset laver et table i stedet for linkedlist m hashmap*/
}

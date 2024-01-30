package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private AppUserRole role;

    // One to Many Relationship
    @OneToMany(mappedBy = "user")
    private Set<NotificationForEmergency> notificationForEmergencies = new HashSet<>();

}

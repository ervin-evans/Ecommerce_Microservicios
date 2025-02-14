package com.evans.users.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "surname", length = 50, nullable = false)
    private String surname;

    @Column(name = "lastname", length = 50, nullable = false)
    private String lastname;

    @Column(name = "username", unique = true, length = 50, nullable = false)
    private String username;

    @Column(name = "password", length = 255, nullable = false)
    private String password;

    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;

    private Boolean isActive =false;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "image_profile")
    private String imageProfile="default.png";

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserRole> userRoles;

    @PrePersist
    private void prePersist() {
        imageProfile="default.png";
        this.createdAt = LocalDate.now();
    }

    @PreUpdate
    private void preUpdate() {
        this.updatedAt = LocalDate.now();
    }
}

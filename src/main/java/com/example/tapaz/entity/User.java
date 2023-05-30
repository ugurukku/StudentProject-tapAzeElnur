package com.example.tapaz.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="Istifadeciler")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name="ad")
    String name;
    @Column(name="Yas")
    Integer age;
    @Column(name="email unvani")
    String mail;

    String password;

    Boolean isActive;

    @Enumerated(EnumType.STRING)
    Role role;


}

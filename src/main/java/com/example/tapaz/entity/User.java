package com.example.tapaz.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="Istifadeciler")
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


}

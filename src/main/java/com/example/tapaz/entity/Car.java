package com.example.tapaz.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name="avtomobil")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name ="reng")
    String color;
    @Column(name = "qiymeti")
    Double qiymet;
    @ManyToOne
     @JoinColumn(name = "model_id",referencedColumnName = "id")
    Model model;
}

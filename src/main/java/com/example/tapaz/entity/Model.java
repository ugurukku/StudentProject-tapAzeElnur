package com.example.tapaz.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Model")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "adi")
    String name;
    @ManyToOne
     @JoinColumn(name = "marka_id",referencedColumnName = "id")
    Marka marka;
}

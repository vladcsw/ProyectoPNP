package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OBJETO_CLASIFICACION {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String descripcion;
    private int clase_clase;
}

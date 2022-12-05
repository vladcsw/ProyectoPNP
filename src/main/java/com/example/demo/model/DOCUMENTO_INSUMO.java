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
public class DOCUMENTO_INSUMO {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private Long insumo_calificacion_id;
    private String nombre;
    private int cantidad;
    private Long insumo_situacion_id;
    private Long insumo_intervenido_id;
    private Long documento_id;

}
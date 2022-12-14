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
public class DOCUMENTO_TELEFONO_EQUIPO {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String numeroImei;
    private String marca;
    private String modelo;
    private Long documento_id;

}
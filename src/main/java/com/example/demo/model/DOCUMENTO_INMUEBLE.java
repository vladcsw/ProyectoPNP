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
public class DOCUMENTO_INMUEBLE {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String descripcion;
    private String ubicación;
    private String uso;
    private int persona_id;
    private Long documento_id;
}

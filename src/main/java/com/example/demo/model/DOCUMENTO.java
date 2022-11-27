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
public class DOCUMENTO {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String descripcion;
    private int documento_estado_id;
    private int documento_caracteristica_id;
    private int id_dcumento_padre;
    private int documento_clasificacion_id;

}

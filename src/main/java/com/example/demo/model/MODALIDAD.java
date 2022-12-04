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
public class MODALIDAD {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private Long modalidad_tipo_id;
    private Long modalidad_empleada_id;
    private String descripcion;

}
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
public class EQUIPO_DOCUMENTO {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String descripcion;
    private int documento_id;
    private int equipo_id;
    private int personal_pnp_id;
    private int grado_pnp_id;
    private int unidad_pnp_id;
}

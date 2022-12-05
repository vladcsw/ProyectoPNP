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
public class PERSONA {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String estadoCivil;
    private String fec_reg;
    private String fec_mod;
    private String dni;
    private int usu_reg;
    private int usu_mod;
    private String estado_activo;
    private String primer_apellido;
    private String segundo_apellido;
    private String fec_nacimiento;
    private int pais_id;
    private int distrito_id;
    private int centro_poblado_id;

}

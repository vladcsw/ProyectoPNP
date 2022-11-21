package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Date;

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
    private String primerApellido;
    private String segundoApellido;
    private Date fechaNacimiento;
    private String natural;
    private String estadoCivil;
    private String genero;
    private String tipoDocumento;
    private String numeroDocumento;
    private String nacionalidad;

        //asunto
        //
        //
        //varchar descripcion

}

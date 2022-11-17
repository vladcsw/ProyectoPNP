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

}

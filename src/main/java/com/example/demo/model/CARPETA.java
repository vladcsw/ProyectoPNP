package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CARPETA {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String nombre;
    private LocalDate fecha;
    private String hora;
    private int carpeta_tipo_id;
    private int carpeta_clasificacion_id;
}

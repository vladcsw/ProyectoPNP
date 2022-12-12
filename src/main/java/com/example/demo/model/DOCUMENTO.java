package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import java.time.LocalDate;
import java.util.Date;

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
    private String asunto;
    //
    private String tipoDocumento;
    private String codigo;
    private LocalDate fecha;
    private String obtencionInformacion;
    private String situacion;
    private String instructor;
    private int disposicion;
    private int documento_prioridad_id;

    //
    private int documento_estado_id;
    private int documento_caracteristica_id;
    private int id_dcumento_padre;
    private int documento_clasificacion_id;
    private int documento_clase_tipo_id;
    private Long documento_organo_id;

    private int carpeta_id;
    //



}

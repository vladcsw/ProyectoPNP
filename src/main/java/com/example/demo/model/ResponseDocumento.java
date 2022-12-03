package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@SuperBuilder
@JsonInclude(NON_NULL)
public class ResponseDocumento {

    //Detalle
    protected Long id;
    private String descripcion;
    private String asunto;
    private String tipoDocumento;
    private String codigo;
    private LocalDate fecha;
    private String obtencionInformacion;
    private String situacion;
    private String instructor;
    private int disposicion;
    //Maestros existentes
    protected String prioridad;
    protected String estado;
    protected String caracteristica;
    protected String clasificacion;
    //Maestros no existentes
    protected String documentoPadre;
    protected String detalle;
    protected String empresa;
    protected String origen;
    protected String persona;
    protected String personal_pnp;
    protected String tipo;
}



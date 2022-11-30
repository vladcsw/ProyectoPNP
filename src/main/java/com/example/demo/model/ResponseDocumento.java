package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@SuperBuilder
@JsonInclude(NON_NULL)
public class ResponseDocumento {
    protected String caracteristica;
    protected String clasificacion;
    protected String detalle;
    protected String empresa;
    protected String estado;
    protected String origen;
    protected String persona;
    protected String personal_pnp;
    protected String tipo;
}

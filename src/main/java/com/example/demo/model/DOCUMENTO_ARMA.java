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
public class DOCUMENTO_ARMA {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private Long arma_tipo_id;
    private String revolver;
    private String calibre;
    private Long arma_calificacion_id;
    private Long persona_propietario_id;
    private Long persona_procesion_id;
    private String numeroSerie;
    private String sucamedCodigo;
    private Long documento_id;


}
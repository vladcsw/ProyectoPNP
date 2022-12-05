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
public class DOCUMENTO_INMUEBLE {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private Long inmueble_tipo_id;
    private String direccion;
    private String ubicacion;
    private Long persona_propietario_id;
    private Long persona_posesion_id;
    private String partidaRegistral;
    private Long documento_id;
}

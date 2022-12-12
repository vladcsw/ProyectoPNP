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
public class DOCUMENTO_TELEFONO {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private Long numeroTelefono;
    private Long persona_proveedor_id;
    private Long persona_propietario_id;
    private Long persona_posesion_id;
    private Long documento_id;

}

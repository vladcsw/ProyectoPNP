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
public class PEDIDO {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private int persona_de;
    private int persona_para;
    private String asunto;
    private String antecedente;
    private String pedido;


}
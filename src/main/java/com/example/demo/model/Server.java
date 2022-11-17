package com.example.demo.model;

import com.example.demo.enumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.util.Date;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Personatest")
public class Server {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String nombres;
    private String apellidopaterno;
    private String apellidomaterno;
    private String estadocivil;
    private String genero;
    private Date fechaNacimiento;
    private String origen;
    private String tipodoc;
    private String numdoc;
    private String departamento;
    private String provincia;
    private String distrito;

}

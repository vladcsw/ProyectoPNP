package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.OptimisticLock;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EQUIPO {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String descripcion;
    private int equipo_tipo_id;
    private int unidad_pnp_id;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "x")
    private Set<EQUIPO_CARGO> d;


}

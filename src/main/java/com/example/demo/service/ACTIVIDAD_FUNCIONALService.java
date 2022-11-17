package com.example.demo.service;

import com.example.demo.model.ACTIVIDAD_FUNCIONAL;
import com.example.demo.model.DOCUMENTO_DETALLE;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Collection;

import static javax.persistence.GenerationType.AUTO;

public interface ACTIVIDAD_FUNCIONALService {
    ACTIVIDAD_FUNCIONAL create(ACTIVIDAD_FUNCIONAL server);
    Collection<ACTIVIDAD_FUNCIONAL> list(int limit);
    ACTIVIDAD_FUNCIONAL get(Long id);
    Boolean delete(Long id);
}

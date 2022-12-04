package com.example.demo.service;

import com.example.demo.model.INSUMO_CALIFICACION;

import java.util.Collection;

public interface INSUMO_CALIFICACIONService {
    INSUMO_CALIFICACION create(INSUMO_CALIFICACION service);
    Collection<INSUMO_CALIFICACION> list(int limit);
    INSUMO_CALIFICACION get(Long id);
    Boolean delete(Long id);
}

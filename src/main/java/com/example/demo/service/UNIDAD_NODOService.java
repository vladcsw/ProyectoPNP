package com.example.demo.service;

import com.example.demo.model.UNIDAD_NODO;

import java.util.Collection;

public interface UNIDAD_NODOService {
    UNIDAD_NODO create(UNIDAD_NODO service);
    Collection<UNIDAD_NODO> list(int limit);
    UNIDAD_NODO get(Long id);
    Boolean delete(Long id);
}

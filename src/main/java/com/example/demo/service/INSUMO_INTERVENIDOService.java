package com.example.demo.service;

import com.example.demo.model.INSUMO_INTERVENIDO;

import java.util.Collection;

public interface INSUMO_INTERVENIDOService {
    INSUMO_INTERVENIDO create(INSUMO_INTERVENIDO service);
    Collection<INSUMO_INTERVENIDO> list(int limit);
    INSUMO_INTERVENIDO get(Long id);
    Boolean delete(Long id);
}

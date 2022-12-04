package com.example.demo.service;

import com.example.demo.model.ARMA_CALIFICACION;

import java.util.Collection;

public interface ARMA_CALIFICACIONService {
    ARMA_CALIFICACION create(ARMA_CALIFICACION service);
    Collection<ARMA_CALIFICACION> list(int limit);
    ARMA_CALIFICACION get(Long id);
    Boolean delete(Long id);
}

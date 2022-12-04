package com.example.demo.service;

import com.example.demo.model.VEHICULO_TIPO;

import java.util.Collection;

public interface VEHICULO_TIPOService {
    VEHICULO_TIPO create(VEHICULO_TIPO service);
    Collection<VEHICULO_TIPO> list(int limit);
    VEHICULO_TIPO get(Long id);
    Boolean delete(Long id);
}

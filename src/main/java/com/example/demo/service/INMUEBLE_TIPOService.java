package com.example.demo.service;

import com.example.demo.model.INMUEBLE_TIPO;

import java.util.Collection;

public interface INMUEBLE_TIPOService {
    INMUEBLE_TIPO create(INMUEBLE_TIPO service);
    Collection<INMUEBLE_TIPO> list(int limit);
    INMUEBLE_TIPO get(Long id);
    Boolean delete(Long id);
}

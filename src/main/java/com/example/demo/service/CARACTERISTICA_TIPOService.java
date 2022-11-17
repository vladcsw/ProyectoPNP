package com.example.demo.service;

import com.example.demo.model.CARACTERISTICA_CLASE;
import com.example.demo.model.CARACTERISTICA_TIPO;

import java.util.Collection;

public interface CARACTERISTICA_TIPOService {
    CARACTERISTICA_TIPO create(CARACTERISTICA_TIPO service);
    Collection<CARACTERISTICA_TIPO> list(int limit);
    CARACTERISTICA_TIPO get(Long id);
    Boolean delete(Long id);
}

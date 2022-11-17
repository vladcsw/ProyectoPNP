package com.example.demo.service;

import com.example.demo.model.EQUIPO_TIPO;

import java.util.Collection;

public interface EQUIPO_TIPOService {
    EQUIPO_TIPO create(EQUIPO_TIPO service);
    Collection<EQUIPO_TIPO> list(int limit);
    EQUIPO_TIPO get(Long id);
    Boolean delete(Long id);
}

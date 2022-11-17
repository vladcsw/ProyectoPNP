package com.example.demo.service;

import com.example.demo.model.RELACION_TIPO;

import java.util.Collection;

public interface RELACION_TIPOService {
    RELACION_TIPO create(RELACION_TIPO service);
    Collection<RELACION_TIPO> list(int limit);
    RELACION_TIPO get(Long id);
    Boolean delete(Long id);
}

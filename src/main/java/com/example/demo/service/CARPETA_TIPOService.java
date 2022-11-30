package com.example.demo.service;

import com.example.demo.model.CARPETA_TIPO;

import java.util.Collection;

public interface CARPETA_TIPOService {
    CARPETA_TIPO create(CARPETA_TIPO service);
    Collection<CARPETA_TIPO> list(int limit);
    CARPETA_TIPO get(Long id);
    Boolean delete(Long id);
}

package com.example.demo.service;

import com.example.demo.model.EQUIPO_CARPETA;

import java.util.Collection;

public interface EQUIPO_CARPETAService {
    EQUIPO_CARPETA create(EQUIPO_CARPETA service);
    Collection<EQUIPO_CARPETA> list(int limit);
    EQUIPO_CARPETA get(Long id);
    Boolean delete(Long id);
}

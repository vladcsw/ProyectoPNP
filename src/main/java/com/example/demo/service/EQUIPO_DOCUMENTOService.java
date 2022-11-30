package com.example.demo.service;

import com.example.demo.model.EQUIPO_DOCUMENTO;

import java.util.Collection;

public interface EQUIPO_DOCUMENTOService {
    EQUIPO_DOCUMENTO create(EQUIPO_DOCUMENTO service);
    Collection<EQUIPO_DOCUMENTO> list(int limit);
    EQUIPO_DOCUMENTO get(Long id);
    Boolean delete(Long id);
}

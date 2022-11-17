package com.example.demo.service;

import com.example.demo.model.CARPETA_CLASIFICACION;
import com.example.demo.model.CARPETA_DOCUMENTO;

import java.util.Collection;

public interface CARPETA_DOCUMENTOService {
    CARPETA_DOCUMENTO create(CARPETA_DOCUMENTO service);
    Collection<CARPETA_DOCUMENTO> list(int limit);
    CARPETA_DOCUMENTO get(Long id);
    Boolean delete(Long id);
}

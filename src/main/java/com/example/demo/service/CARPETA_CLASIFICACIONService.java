package com.example.demo.service;

import com.example.demo.model.CARGO_PNP;
import com.example.demo.model.CARPETA_CLASIFICACION;

import java.util.Collection;

public interface CARPETA_CLASIFICACIONService {
    CARPETA_CLASIFICACION create(CARPETA_CLASIFICACION service);
    Collection<CARPETA_CLASIFICACION> list(int limit);
    CARPETA_CLASIFICACION get(Long id);
    Boolean delete(Long id);
}

package com.example.demo.service;

import com.example.demo.model.CARACTERISTICA_CLASE;
import com.example.demo.model.DOCUMENTO_DETALLE;

import java.util.Collection;

public interface CARACTERISTICA_CLASEService {
    CARACTERISTICA_CLASE create(CARACTERISTICA_CLASE service);
    Collection<CARACTERISTICA_CLASE> list(int limit);
    CARACTERISTICA_CLASE get(Long id);
    Boolean delete(Long id);
}

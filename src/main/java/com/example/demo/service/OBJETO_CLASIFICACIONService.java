package com.example.demo.service;

import com.example.demo.model.OBJETO_CLASIFICACION;

import java.util.Collection;

public interface OBJETO_CLASIFICACIONService {
    OBJETO_CLASIFICACION create(OBJETO_CLASIFICACION service);
    Collection<OBJETO_CLASIFICACION> list(int limit);
    OBJETO_CLASIFICACION get(Long id);
    Boolean delete(Long id);
}

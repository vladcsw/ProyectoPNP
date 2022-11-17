package com.example.demo.service;

import com.example.demo.model.DOCUMENTO_CLASIFICACION;

import java.util.Collection;

public interface DOCUMENTO_CLASIFICACIONService {
    DOCUMENTO_CLASIFICACION create(DOCUMENTO_CLASIFICACION service);
    Collection<DOCUMENTO_CLASIFICACION> list(int limit);
    DOCUMENTO_CLASIFICACION get(Long id);
    Boolean delete(Long id);
}

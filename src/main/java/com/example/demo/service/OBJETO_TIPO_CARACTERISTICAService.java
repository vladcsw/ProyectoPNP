package com.example.demo.service;

import com.example.demo.model.OBJETO_TIPO_CARACTERISTICA;

import java.util.Collection;

public interface OBJETO_TIPO_CARACTERISTICAService {
    OBJETO_TIPO_CARACTERISTICA create(OBJETO_TIPO_CARACTERISTICA service);
    Collection<OBJETO_TIPO_CARACTERISTICA> list(int limit);
    OBJETO_TIPO_CARACTERISTICA get(Long id);
    Boolean delete(Long id);
}

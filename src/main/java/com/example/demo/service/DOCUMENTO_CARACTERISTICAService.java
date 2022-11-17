package com.example.demo.service;

import com.example.demo.model.DOCUMENTO_CARACTERISTICA;

import java.util.Collection;

public interface DOCUMENTO_CARACTERISTICAService {
    DOCUMENTO_CARACTERISTICA create(DOCUMENTO_CARACTERISTICA service);
    Collection<DOCUMENTO_CARACTERISTICA> list(int limit);
    DOCUMENTO_CARACTERISTICA get(Long id);
    Boolean delete(Long id);
}

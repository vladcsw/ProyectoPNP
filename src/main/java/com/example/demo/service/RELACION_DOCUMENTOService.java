package com.example.demo.service;

import com.example.demo.model.RELACION_DOCUMENTO;

import java.util.Collection;

public interface RELACION_DOCUMENTOService {
    RELACION_DOCUMENTO create(RELACION_DOCUMENTO service);
    Collection<RELACION_DOCUMENTO> list(int limit);
    RELACION_DOCUMENTO get(Long id);
    Boolean delete(Long id);
}

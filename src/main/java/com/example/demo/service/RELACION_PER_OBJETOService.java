package com.example.demo.service;

import com.example.demo.model.RELACION_PER_OBJETO;

import java.util.Collection;

public interface RELACION_PER_OBJETOService {
    RELACION_PER_OBJETO create(RELACION_PER_OBJETO service);
    Collection<RELACION_PER_OBJETO> list(int limit);
    RELACION_PER_OBJETO get(Long id);
    Boolean delete(Long id);
}

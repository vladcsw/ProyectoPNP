package com.example.demo.service;

import com.example.demo.model.RELACION_EMP_OBJETO;

import java.util.Collection;

public interface RELACION_EMP_OBJETOService {
    RELACION_EMP_OBJETO create(RELACION_EMP_OBJETO service);
    Collection<RELACION_EMP_OBJETO> list(int limit);
    RELACION_EMP_OBJETO get(Long id);
    Boolean delete(Long id);
}

package com.example.demo.service;

import com.example.demo.model.EMPRESA_OBJETO;

import java.util.Collection;

public interface EMPRESA_OBJETOService {
    EMPRESA_OBJETO create(EMPRESA_OBJETO service);
    Collection<EMPRESA_OBJETO> list(int limit);
    EMPRESA_OBJETO get(Long id);
    Boolean delete(Long id);
}

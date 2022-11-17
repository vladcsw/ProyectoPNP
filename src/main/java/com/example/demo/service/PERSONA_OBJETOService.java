package com.example.demo.service;

import com.example.demo.model.PERSONA_OBJETO;

import java.util.Collection;

public interface PERSONA_OBJETOService {
    PERSONA_OBJETO create(PERSONA_OBJETO service);
    Collection<PERSONA_OBJETO> list(int limit);
    PERSONA_OBJETO get(Long id);
    Boolean delete(Long id);
}

package com.example.demo.service;

import com.example.demo.model.PERSONAL_GRADO;

import java.util.Collection;

public interface PERSONAL_GRADOService {
    PERSONAL_GRADO create(PERSONAL_GRADO service);
    Collection<PERSONAL_GRADO> list(int limit);
    PERSONAL_GRADO get(Long id);
    Boolean delete(Long id);
}

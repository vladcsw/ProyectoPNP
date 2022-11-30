package com.example.demo.service;

import com.example.demo.model.CENTRO_POBLADO;

import java.util.Collection;

public interface CENTRO_POBLADOService {
    CENTRO_POBLADO create(CENTRO_POBLADO service);
    Collection<CENTRO_POBLADO> list(int limit);
    CENTRO_POBLADO get(Long id);
    Boolean delete(Long id);
}

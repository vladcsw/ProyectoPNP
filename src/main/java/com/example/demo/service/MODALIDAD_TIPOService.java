package com.example.demo.service;

import com.example.demo.model.MODALIDAD_TIPO;

import java.util.Collection;

public interface MODALIDAD_TIPOService {
    MODALIDAD_TIPO create(MODALIDAD_TIPO service);
    Collection<MODALIDAD_TIPO> list(int limit);
    MODALIDAD_TIPO get(Long id);
    Boolean delete(Long id);
}

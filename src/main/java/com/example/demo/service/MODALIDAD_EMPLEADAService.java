package com.example.demo.service;

import com.example.demo.model.MODALIDAD_EMPLEADA;

import java.util.Collection;

public interface MODALIDAD_EMPLEADAService {
    MODALIDAD_EMPLEADA create(MODALIDAD_EMPLEADA service);
    Collection<MODALIDAD_EMPLEADA> list(int limit);
    MODALIDAD_EMPLEADA get(Long id);
    Boolean delete(Long id);
}

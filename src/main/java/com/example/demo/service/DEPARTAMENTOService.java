package com.example.demo.service;

import com.example.demo.model.DEPARTAMENTO;

import java.util.Collection;

public interface DEPARTAMENTOService {
    DEPARTAMENTO create(DEPARTAMENTO service);
    Collection<DEPARTAMENTO> list(int limit);
    DEPARTAMENTO get(Long id);
    Boolean delete(Long id);
}

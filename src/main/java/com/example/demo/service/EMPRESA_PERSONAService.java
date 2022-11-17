package com.example.demo.service;

import com.example.demo.model.EMPRESA_DOMICILIO;
import com.example.demo.model.EMPRESA_PERSONA;

import java.util.Collection;

public interface EMPRESA_PERSONAService {
    EMPRESA_PERSONA create(EMPRESA_PERSONA server);
    Collection<EMPRESA_PERSONA> list(int limit);
    EMPRESA_PERSONA get(Long id);
    Boolean delete(Long id);
}

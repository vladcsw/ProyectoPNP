package com.example.demo.service;

import com.example.demo.model.RELACION_PER_DOMICILIO;
import com.example.demo.model.RELACION_PER_EMPRESA;

import java.util.Collection;

public interface RELACION_PER_EMPRESAService {
    RELACION_PER_EMPRESA create(RELACION_PER_EMPRESA server);
    Collection<RELACION_PER_EMPRESA> list(int limit);
    RELACION_PER_EMPRESA get(Long id);
    Boolean delete(Long id);
}

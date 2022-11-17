package com.example.demo.service;

import com.example.demo.model.EMPRESA;
import com.example.demo.model.PERSONA_DOMICILIO;

import java.util.Collection;

public interface PERSONA_DOMICILIOService {
    PERSONA_DOMICILIO create( PERSONA_DOMICILIO server);
    Collection<PERSONA_DOMICILIO> list(int limit);
    PERSONA_DOMICILIO get(Long id);
    Boolean delete(Long id);
}

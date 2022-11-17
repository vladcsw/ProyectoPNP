package com.example.demo.service;

import com.example.demo.model.PERSONA;
import com.example.demo.model.RELACION_EMP_DOMICILIO;

import java.util.Collection;

public interface RELACION_EMP_DOMICILIOService {
    RELACION_EMP_DOMICILIO create(RELACION_EMP_DOMICILIO server);
    Collection<RELACION_EMP_DOMICILIO> list(int limit);
    RELACION_EMP_DOMICILIO get(Long id);
    Boolean delete(Long id);
}

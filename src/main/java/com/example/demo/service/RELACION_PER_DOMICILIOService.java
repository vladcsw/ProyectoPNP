package com.example.demo.service;

import com.example.demo.model.RELACION_EMP_DOMICILIO;
import com.example.demo.model.RELACION_PER_DOMICILIO;

import java.util.Collection;

public interface RELACION_PER_DOMICILIOService {
    RELACION_PER_DOMICILIO create(RELACION_PER_DOMICILIO server);
    Collection<RELACION_PER_DOMICILIO> list(int limit);
    RELACION_PER_DOMICILIO get(Long id);
    Boolean delete(Long id);
}

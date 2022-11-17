package com.example.demo.service;

import com.example.demo.model.DOCUMENTO;
import com.example.demo.model.EMPRESA_DOMICILIO;

import java.util.Collection;

public interface EMPRESA_DOMICILIOService {
    EMPRESA_DOMICILIO create(EMPRESA_DOMICILIO server);
    Collection<EMPRESA_DOMICILIO> list(int limit);
    EMPRESA_DOMICILIO get(Long id);
    Boolean delete(Long id);
}

package com.example.demo.service;

import com.example.demo.model.DOCUMENTO;
import com.example.demo.model.DOMICILIO;

import java.util.Collection;

public interface DOMICILIOService {
    DOMICILIO create(DOMICILIO server);
    Collection<DOMICILIO> list(int limit);
    DOMICILIO get(Long id);
    Boolean delete(Long id);
}

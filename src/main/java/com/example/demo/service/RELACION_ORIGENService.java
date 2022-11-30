package com.example.demo.service;

import com.example.demo.model.RELACION_ORIGEN;

import java.util.Collection;

public interface RELACION_ORIGENService {
    RELACION_ORIGEN create(RELACION_ORIGEN service);
    Collection<RELACION_ORIGEN> list(int limit);
    RELACION_ORIGEN get(Long id);
    Boolean delete(Long id);
}

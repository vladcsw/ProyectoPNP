package com.example.demo.service;

import com.example.demo.model.DOCUMENTO_CLASE_TIPO;

import java.util.Collection;

public interface DOCUMENTO_CLASE_TIPOService {
    DOCUMENTO_CLASE_TIPO create(DOCUMENTO_CLASE_TIPO service);
    Collection<DOCUMENTO_CLASE_TIPO> list(int limit);
    DOCUMENTO_CLASE_TIPO get(Long id);
    Boolean delete(Long id);
}

package com.example.demo.service;

import com.example.demo.model.DOCUMENTO_TIPO;

import java.util.Collection;

public interface DOCUMENTO_TIPOService {
    DOCUMENTO_TIPO create(DOCUMENTO_TIPO service);
    Collection<DOCUMENTO_TIPO> list(int limit);
    DOCUMENTO_TIPO get(Long id);
    Boolean delete(Long id);
}

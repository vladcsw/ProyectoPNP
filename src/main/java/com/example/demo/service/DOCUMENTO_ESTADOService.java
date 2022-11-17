package com.example.demo.service;

import com.example.demo.model.DOCUMENTO_ESTADO;

import java.util.Collection;

public interface DOCUMENTO_ESTADOService {
    DOCUMENTO_ESTADO create(DOCUMENTO_ESTADO service);
    Collection<DOCUMENTO_ESTADO> list(int limit);
    DOCUMENTO_ESTADO get(Long id);
    Boolean delete(Long id);
}

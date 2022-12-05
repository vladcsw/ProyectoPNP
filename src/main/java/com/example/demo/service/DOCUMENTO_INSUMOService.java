package com.example.demo.service;

import com.example.demo.model.DOCUMENTO_INSUMO;

import java.util.Collection;

public interface DOCUMENTO_INSUMOService {
    DOCUMENTO_INSUMO create(DOCUMENTO_INSUMO service);
    Collection<DOCUMENTO_INSUMO> list(int limit);
    DOCUMENTO_INSUMO get(Long id);
    Boolean delete(Long id);
}

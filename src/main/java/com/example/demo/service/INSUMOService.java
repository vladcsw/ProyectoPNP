package com.example.demo.service;

import com.example.demo.model.INSUMO;

import java.util.Collection;

public interface INSUMOService {
    INSUMO create(INSUMO service);
    Collection<INSUMO> list(int limit);
    INSUMO get(Long id);
    Boolean delete(Long id);
}

package com.example.demo.service;

import com.example.demo.model.MODELO;

import java.util.Collection;

public interface MODELOService {
    MODELO create(MODELO service);
    Collection<MODELO> list(int limit);
    MODELO get(Long id);
    Boolean delete(Long id);
}

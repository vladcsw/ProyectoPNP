package com.example.demo.service;

import com.example.demo.model.OBJETO_CARACTERISICA;

import java.util.Collection;

public interface OBJETO_CARACTERISICAService {
    OBJETO_CARACTERISICA create(OBJETO_CARACTERISICA service);
    Collection<OBJETO_CARACTERISICA> list(int limit);
    OBJETO_CARACTERISICA get(Long id);
    Boolean delete(Long id);
}

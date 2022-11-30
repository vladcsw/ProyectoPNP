package com.example.demo.service;

import com.example.demo.model.PAIS;

import java.util.Collection;

public interface PAISService {
    PAIS create(PAIS service);
    Collection<PAIS> list(int limit);
    PAIS get(Long id);
    Boolean delete(Long id);
}

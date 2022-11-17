package com.example.demo.service;

import com.example.demo.model.OBJETO_CLASE;

import java.util.Collection;

public interface OBJETO_CLASEService {
    OBJETO_CLASE create(OBJETO_CLASE service);
    Collection<OBJETO_CLASE> list(int limit);
    OBJETO_CLASE get(Long id);
    Boolean delete(Long id);
}

package com.example.demo.service;

import com.example.demo.model.OBJETO_TIPO;

import java.util.Collection;

public interface OBJETO_TIPOService {
    OBJETO_TIPO create(OBJETO_TIPO service);
    Collection<OBJETO_TIPO> list(int limit);
    OBJETO_TIPO get(Long id);
    Boolean delete(Long id);
}

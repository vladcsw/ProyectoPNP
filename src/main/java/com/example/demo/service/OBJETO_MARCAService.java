package com.example.demo.service;

import com.example.demo.model.OBJETO_MARCA;

import java.util.Collection;

public interface OBJETO_MARCAService {
    OBJETO_MARCA create(OBJETO_MARCA service);
    Collection<OBJETO_MARCA> list(int limit);
    OBJETO_MARCA get(Long id);
    Boolean delete(Long id);
}

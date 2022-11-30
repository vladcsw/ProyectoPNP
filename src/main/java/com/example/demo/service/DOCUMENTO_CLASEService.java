package com.example.demo.service;

import com.example.demo.model.DOCUMENTO_CLASE;

import java.util.Collection;

public interface DOCUMENTO_CLASEService {
    DOCUMENTO_CLASE create(DOCUMENTO_CLASE service);
    Collection<DOCUMENTO_CLASE> list(int limit);
    DOCUMENTO_CLASE get(Long id);
    Boolean delete(Long id);
}

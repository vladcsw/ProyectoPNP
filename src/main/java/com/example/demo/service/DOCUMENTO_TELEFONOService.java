package com.example.demo.service;

import com.example.demo.model.DOCUMENTO_TELEFONO;

import java.util.Collection;

public interface DOCUMENTO_TELEFONOService {
    DOCUMENTO_TELEFONO create(DOCUMENTO_TELEFONO service);
    Collection<DOCUMENTO_TELEFONO> list(int limit);
    DOCUMENTO_TELEFONO get(Long id);
    Boolean delete(Long id);
}

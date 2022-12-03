package com.example.demo.service;

import com.example.demo.model.DOCUMENTO_INMUEBLE;

import java.util.Collection;

public interface DOCUMENTO_INMUEBLEService {
    DOCUMENTO_INMUEBLE create(DOCUMENTO_INMUEBLE service);
    Collection<DOCUMENTO_INMUEBLE> list(int limit);
    DOCUMENTO_INMUEBLE get(Long id);
    Boolean delete(Long id);
}

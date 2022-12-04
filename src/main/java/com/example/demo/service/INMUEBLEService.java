package com.example.demo.service;

import com.example.demo.model.INMUEBLE;

import java.util.Collection;

public interface INMUEBLEService {
    INMUEBLE create(INMUEBLE service);
    Collection<INMUEBLE> list(int limit);
    INMUEBLE get(Long id);
    Boolean delete(Long id);
}

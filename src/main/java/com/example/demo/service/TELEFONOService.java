package com.example.demo.service;

import com.example.demo.model.TELEFONO;

import java.util.Collection;

public interface TELEFONOService {
    TELEFONO create(TELEFONO service);
    Collection<TELEFONO> list(int limit);
    TELEFONO get(Long id);
    Boolean delete(Long id);
}

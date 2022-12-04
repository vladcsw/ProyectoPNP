package com.example.demo.service;

import com.example.demo.model.INMUEBLE_TPO_ZONA;

import java.util.Collection;

public interface INMUEBLE_TPO_ZONAService {
    INMUEBLE_TPO_ZONA create(INMUEBLE_TPO_ZONA service);
    Collection<INMUEBLE_TPO_ZONA> list(int limit);
    INMUEBLE_TPO_ZONA get(Long id);
    Boolean delete(Long id);
}

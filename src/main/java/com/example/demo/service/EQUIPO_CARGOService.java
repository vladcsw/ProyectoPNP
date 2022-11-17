package com.example.demo.service;

import com.example.demo.model.EQUIPO_CARGO;

import java.util.Collection;

public interface EQUIPO_CARGOService {
    EQUIPO_CARGO create(EQUIPO_CARGO service);
    Collection<EQUIPO_CARGO> list(int limit);
    EQUIPO_CARGO get(Long id);
    Boolean delete(Long id);
}

package com.example.demo.service;

import com.example.demo.model.EQUIPO;

import java.util.Collection;

public interface EQUIPOService {
    EQUIPO create(EQUIPO service);
    Collection<EQUIPO> list(int limit);
    EQUIPO get(Long id);
    Boolean delete(Long id);
}

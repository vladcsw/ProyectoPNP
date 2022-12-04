package com.example.demo.service;

import com.example.demo.model.TELEFONO_EQUIPO;

import java.util.Collection;

public interface TELEFONO_EQUIPOService {
    TELEFONO_EQUIPO create(TELEFONO_EQUIPO service);
    Collection<TELEFONO_EQUIPO> list(int limit);
    TELEFONO_EQUIPO get(Long id);
    Boolean delete(Long id);
}

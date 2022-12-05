package com.example.demo.service;

import com.example.demo.model.DOCUMENTO_TELEFONO_EQUIPO;

import java.util.Collection;

public interface DOCUMENTO_TELEFONO_EQUIPOService {
    DOCUMENTO_TELEFONO_EQUIPO create(DOCUMENTO_TELEFONO_EQUIPO service);
    Collection<DOCUMENTO_TELEFONO_EQUIPO> list(int limit);
    DOCUMENTO_TELEFONO_EQUIPO get(Long id);
    Boolean delete(Long id);
}

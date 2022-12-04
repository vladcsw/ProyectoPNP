package com.example.demo.service;

import com.example.demo.model.INSUMO_SITUACION;

import java.util.Collection;

public interface INSUMO_SITUACIONService {
    INSUMO_SITUACION create(INSUMO_SITUACION service);
    Collection<INSUMO_SITUACION> list(int limit);
    INSUMO_SITUACION get(Long id);
    Boolean delete(Long id);
}

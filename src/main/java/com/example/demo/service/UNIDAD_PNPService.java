package com.example.demo.service;

import com.example.demo.model.UNIDAD_PNP;

import java.util.Collection;

public interface UNIDAD_PNPService {
    UNIDAD_PNP create(UNIDAD_PNP service);
    Collection<UNIDAD_PNP> list(int limit);
    UNIDAD_PNP get(Long id);
    Boolean delete(Long id);
}

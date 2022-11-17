package com.example.demo.service;

import com.example.demo.model.GRADO_PNP;

import java.util.Collection;

public interface GRADO_PNPService {
    GRADO_PNP create(GRADO_PNP service);
    Collection<GRADO_PNP> list(int limit);
    GRADO_PNP get(Long id);
    Boolean delete(Long id);
}

package com.example.demo.service;

import com.example.demo.model.CARPETA;

import java.util.Collection;

public interface CARPETAService {
    CARPETA create(CARPETA service);
    Collection<CARPETA> list(int limit);
    CARPETA get(Long id);
    Boolean delete(Long id);
}

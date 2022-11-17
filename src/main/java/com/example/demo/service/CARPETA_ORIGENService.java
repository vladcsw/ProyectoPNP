package com.example.demo.service;

import com.example.demo.model.CARPETA_DOCUMENTO;
import com.example.demo.model.CARPETA_ORIGEN;

import java.util.Collection;

public interface CARPETA_ORIGENService {
    CARPETA_ORIGEN create(CARPETA_ORIGEN service);
    Collection<CARPETA_ORIGEN> list(int limit);
    CARPETA_ORIGEN get(Long id);
    Boolean delete(Long id);
}

package com.example.demo.service;

import com.example.demo.model.CARACTERISTICA;
import com.example.demo.model.CARACTERISTICA_TIPO;

import java.util.Collection;

public interface CARACTERISTICAService {
    CARACTERISTICA create(CARACTERISTICA service);
    Collection<CARACTERISTICA> list(int limit);
    CARACTERISTICA get(Long id);
    Boolean delete(Long id);

}

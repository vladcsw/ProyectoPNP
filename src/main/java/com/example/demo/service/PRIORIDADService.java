package com.example.demo.service;

import com.example.demo.model.PRIORIDAD;

import java.util.Collection;

public interface PRIORIDADService {
    PRIORIDAD create(PRIORIDAD service);
    Collection<PRIORIDAD> list(int limit);
    PRIORIDAD get(Long id);
    Boolean delete(Long id);
}

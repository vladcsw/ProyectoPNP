package com.example.demo.service;

import com.example.demo.model.NACIONALIDAD;

import java.util.Collection;

public interface NACIONALIDADService {
    NACIONALIDAD create(NACIONALIDAD service);
    Collection<NACIONALIDAD> list(int limit);
    NACIONALIDAD get(Long id);
    Boolean delete(Long id);
}

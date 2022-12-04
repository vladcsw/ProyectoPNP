package com.example.demo.service;

import com.example.demo.model.MODALIDAD;

import java.util.Collection;

public interface MODALIDADService {
    MODALIDAD create(MODALIDAD service);
    Collection<MODALIDAD> list(int limit);
    MODALIDAD get(Long id);
    Boolean delete(Long id);
}

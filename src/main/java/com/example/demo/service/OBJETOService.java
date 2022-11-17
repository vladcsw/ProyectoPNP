package com.example.demo.service;

import com.example.demo.model.OBJETO;

import java.util.Collection;

public interface OBJETOService {
    OBJETO create(OBJETO service);
    Collection<OBJETO> list(int limit);
    OBJETO get(Long id);
    Boolean delete(Long id);
}

package com.example.demo.service;

import com.example.demo.model.PROVINCIA;

import java.util.Collection;

public interface PROVINCIAService {
    PROVINCIA create(PROVINCIA service);
    Collection<PROVINCIA> list(int limit);
    PROVINCIA get(Long id);
    Boolean delete(Long id);
}

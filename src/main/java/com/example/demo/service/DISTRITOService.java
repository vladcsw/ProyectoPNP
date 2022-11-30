package com.example.demo.service;

import com.example.demo.model.DISTRITO;

import java.util.Collection;

public interface DISTRITOService {
    DISTRITO create(DISTRITO service);
    Collection<DISTRITO> list(int limit);
    DISTRITO get(Long id);
    Boolean delete(Long id);
}

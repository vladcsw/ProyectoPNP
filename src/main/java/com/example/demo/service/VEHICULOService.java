package com.example.demo.service;

import com.example.demo.model.VEHICULO;

import java.util.Collection;

public interface VEHICULOService {
    VEHICULO create(VEHICULO service);
    Collection<VEHICULO> list(int limit);
    VEHICULO get(Long id);
    Boolean delete(Long id);
}

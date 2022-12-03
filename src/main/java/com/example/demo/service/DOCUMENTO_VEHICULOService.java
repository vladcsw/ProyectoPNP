package com.example.demo.service;

import com.example.demo.model.DOCUMENTO_VEHICULO;

import java.util.Collection;

public interface DOCUMENTO_VEHICULOService {
    DOCUMENTO_VEHICULO create(DOCUMENTO_VEHICULO service);
    Collection<DOCUMENTO_VEHICULO> list(int limit);
    DOCUMENTO_VEHICULO get(Long id);
    Boolean delete(Long id);
}

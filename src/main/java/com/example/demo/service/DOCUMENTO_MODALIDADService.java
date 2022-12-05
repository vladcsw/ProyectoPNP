package com.example.demo.service;

import com.example.demo.model.DOCUMENTO_MODALIDAD;

import java.util.Collection;

public interface DOCUMENTO_MODALIDADService {
    DOCUMENTO_MODALIDAD create(DOCUMENTO_MODALIDAD service);
    Collection<DOCUMENTO_MODALIDAD> list(int limit);
    DOCUMENTO_MODALIDAD get(Long id);
    Boolean delete(Long id);
}

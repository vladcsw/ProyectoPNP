package com.example.demo.service;

import com.example.demo.model.DOCUMENTO_ORIGEN;

import java.util.Collection;

public interface DOCUMENTO_ORIGENService {
    DOCUMENTO_ORIGEN create(DOCUMENTO_ORIGEN service);
    Collection<DOCUMENTO_ORIGEN> list(int limit);
    DOCUMENTO_ORIGEN get(Long id);
    Boolean delete(Long id);
}

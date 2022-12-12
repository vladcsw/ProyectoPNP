package com.example.demo.service;

import com.example.demo.model.DOCUMENTO_ORGANO;

import java.util.Collection;

public interface DOCUMENTO_ORGANOService {
    DOCUMENTO_ORGANO create(DOCUMENTO_ORGANO service);
    Collection<DOCUMENTO_ORGANO> list(int limit);
    DOCUMENTO_ORGANO get(Long id);
    Boolean delete(Long id);
}

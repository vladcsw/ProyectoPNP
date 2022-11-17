package com.example.demo.service;

import com.example.demo.model.DOCUMENTO;
import com.example.demo.model.DOCUMENTO_PERSONA;

import java.util.Collection;

public interface DOCUMENTOService {
    DOCUMENTO create(DOCUMENTO server);
    Collection<DOCUMENTO> list(int limit);
    DOCUMENTO get(Long id);
    Boolean delete(Long id);
}

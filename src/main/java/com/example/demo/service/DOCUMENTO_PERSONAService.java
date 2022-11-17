package com.example.demo.service;

import com.example.demo.model.DOCUMENTO_EMPRESA;
import com.example.demo.model.DOCUMENTO_PERSONA;

import java.util.Collection;

public interface DOCUMENTO_PERSONAService {
    DOCUMENTO_PERSONA create(DOCUMENTO_PERSONA server);
    Collection<DOCUMENTO_PERSONA> list(int limit);
    DOCUMENTO_PERSONA get(Long id);
    Boolean delete(Long id);
}

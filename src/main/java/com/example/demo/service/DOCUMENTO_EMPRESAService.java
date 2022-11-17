package com.example.demo.service;

import com.example.demo.model.DOCUMENTO_DETALLE;
import com.example.demo.model.DOCUMENTO_EMPRESA;

import java.util.Collection;

public interface DOCUMENTO_EMPRESAService {
    DOCUMENTO_EMPRESA create(DOCUMENTO_EMPRESA server);
    Collection<DOCUMENTO_EMPRESA> list(int limit);
    DOCUMENTO_EMPRESA get(Long id);
    Boolean delete(Long id);
}

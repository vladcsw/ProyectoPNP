package com.example.demo.service;

import com.example.demo.model.EMPRESA;
import com.example.demo.model.EMPRESA_PERSONA;

import java.util.Collection;

public interface EMPRESAService {
    EMPRESA create(EMPRESA server);
    Collection<EMPRESA> list(int limit);
    EMPRESA get(Long id);
    Boolean delete(Long id);
}

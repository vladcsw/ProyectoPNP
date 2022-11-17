package com.example.demo.service;

import com.example.demo.model.PERSONAL_PNP;
import com.example.demo.model.PERSONA_DOMICILIO;

import java.util.Collection;

public interface PERSONAL_PNPService {
    PERSONAL_PNP create(PERSONAL_PNP server);
    Collection<PERSONAL_PNP> list(int limit);
    PERSONAL_PNP get(Long id);
    Boolean delete(Long id);
}

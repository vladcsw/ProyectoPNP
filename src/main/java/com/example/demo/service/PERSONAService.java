package com.example.demo.service;

import com.example.demo.model.PERSONA;
import com.example.demo.model.PERSONAL_PNP;

import java.util.Collection;

public interface PERSONAService {
    PERSONA create(PERSONA server);
    Collection<PERSONA> list(int limit);
    PERSONA get(Long id);
    PERSONA getByDNI(String dni);
    Boolean delete(Long id);
    
}

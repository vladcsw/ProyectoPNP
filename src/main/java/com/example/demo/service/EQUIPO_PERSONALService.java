package com.example.demo.service;

import com.example.demo.model.EQUIPO_PERSONAL;

import java.util.Collection;

public interface EQUIPO_PERSONALService {
    EQUIPO_PERSONAL create(EQUIPO_PERSONAL service);
    Collection<EQUIPO_PERSONAL> list(int limit);
    EQUIPO_PERSONAL get(Long id);
    Boolean delete(Long id);
}

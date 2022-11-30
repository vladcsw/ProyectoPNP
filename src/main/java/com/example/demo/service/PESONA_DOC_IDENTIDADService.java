package com.example.demo.service;

import com.example.demo.model.PESONA_DOC_IDENTIDAD;

import java.util.Collection;

public interface PESONA_DOC_IDENTIDADService {
    PESONA_DOC_IDENTIDAD create(PESONA_DOC_IDENTIDAD service);
    Collection<PESONA_DOC_IDENTIDAD> list(int limit);
    PESONA_DOC_IDENTIDAD get(Long id);
    Boolean delete(Long id);
}

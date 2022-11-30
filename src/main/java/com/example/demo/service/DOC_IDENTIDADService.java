package com.example.demo.service;

import com.example.demo.model.DOC_IDENTIDAD;

import java.util.Collection;

public interface DOC_IDENTIDADService {
    DOC_IDENTIDAD create(DOC_IDENTIDAD service);
    Collection<DOC_IDENTIDAD> list(int limit);
    DOC_IDENTIDAD get(Long id);
    Boolean delete(Long id);
}

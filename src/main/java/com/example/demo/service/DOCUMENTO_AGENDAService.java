package com.example.demo.service;

import com.example.demo.model.DOCUMENTO_AGENDA;

import java.util.Collection;

public interface DOCUMENTO_AGENDAService {
    DOCUMENTO_AGENDA create(DOCUMENTO_AGENDA service);
    Collection<DOCUMENTO_AGENDA> list(int limit);
    DOCUMENTO_AGENDA get(Long id);
    Boolean delete(Long id);
}

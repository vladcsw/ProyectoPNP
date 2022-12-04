package com.example.demo.service;

import com.example.demo.model.AGENDA;

import java.util.Collection;

public interface AGENDAService {
    AGENDA create(AGENDA service);
    Collection<AGENDA> list(int limit);
    AGENDA get(Long id);
    Boolean delete(Long id);
}

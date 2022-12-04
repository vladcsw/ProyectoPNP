package com.example.demo.service;

import com.example.demo.model.ARMA;

import java.util.Collection;

public interface ARMAService {
    ARMA create(ARMA service);
    Collection<ARMA> list(int limit);
    ARMA get(Long id);
    Boolean delete(Long id);
}

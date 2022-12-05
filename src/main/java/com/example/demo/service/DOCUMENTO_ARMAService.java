package com.example.demo.service;

import com.example.demo.model.DOCUMENTO_ARMA;

import java.util.Collection;

public interface DOCUMENTO_ARMAService {
    DOCUMENTO_ARMA create(DOCUMENTO_ARMA service);
    Collection<DOCUMENTO_ARMA> list(int limit);
    DOCUMENTO_ARMA get(Long id);
    Boolean delete(Long id);
}

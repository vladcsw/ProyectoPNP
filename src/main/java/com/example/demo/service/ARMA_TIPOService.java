package com.example.demo.service;

import com.example.demo.model.ARMA_TIPO;

import java.util.Collection;

public interface ARMA_TIPOService {
    ARMA_TIPO create(ARMA_TIPO service);
    Collection<ARMA_TIPO> list(int limit);
    ARMA_TIPO get(Long id);
    Boolean delete(Long id);
}

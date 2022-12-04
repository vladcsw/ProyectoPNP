package com.example.demo.service;

import com.example.demo.model.CUENTA_BANCARIA;

import java.util.Collection;

public interface CUENTA_BANCARIAService {
    CUENTA_BANCARIA create(CUENTA_BANCARIA service);
    Collection<CUENTA_BANCARIA> list(int limit);
    CUENTA_BANCARIA get(Long id);
    Boolean delete(Long id);
}

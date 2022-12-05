package com.example.demo.service;

import com.example.demo.model.DOCUMENTO_CUENTA_BANCARIA;

import java.util.Collection;

public interface DOCUMENTO_CUENTA_BANCARIAService {
    DOCUMENTO_CUENTA_BANCARIA create(DOCUMENTO_CUENTA_BANCARIA service);
    Collection<DOCUMENTO_CUENTA_BANCARIA> list(int limit);
    DOCUMENTO_CUENTA_BANCARIA get(Long id);
    Boolean delete(Long id);
}

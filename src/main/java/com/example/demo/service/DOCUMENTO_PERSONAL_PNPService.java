package com.example.demo.service;

import com.example.demo.model.DOCUMENTO_PERSONAL_PNP;

import java.util.Collection;

public interface DOCUMENTO_PERSONAL_PNPService {
    DOCUMENTO_PERSONAL_PNP create(DOCUMENTO_PERSONAL_PNP service);
    Collection<DOCUMENTO_PERSONAL_PNP> list(int limit);
    DOCUMENTO_PERSONAL_PNP get(Long id);
    Boolean delete(Long id);
}

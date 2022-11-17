package com.example.demo.service;

import com.example.demo.model.CARACTERISTICA;
import com.example.demo.model.CARGO_PNP;

import java.util.Collection;

public interface CARGO_PNPService {
    CARGO_PNP create(CARGO_PNP service);
    Collection<CARGO_PNP> list(int limit);
    CARGO_PNP get(Long id);
    Boolean delete(Long id);
}

package com.example.demo.service;

import com.example.demo.model.DOCUMENTO_DETALLE;
import com.example.demo.model.Server;

import java.util.Collection;

public interface DOCUMENTO_DETALLEService {
    DOCUMENTO_DETALLE create(DOCUMENTO_DETALLE server);
    Collection<DOCUMENTO_DETALLE> list(int limit);
    DOCUMENTO_DETALLE get(Long id);
    Boolean delete(Long id);
}

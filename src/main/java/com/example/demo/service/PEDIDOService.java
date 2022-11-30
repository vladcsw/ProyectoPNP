package com.example.demo.service;

import com.example.demo.model.PEDIDO;

import java.util.Collection;

public interface PEDIDOService {
    PEDIDO create(PEDIDO service);
    Collection<PEDIDO> list(int limit);
    PEDIDO get(Long id);
    Boolean delete(Long id);
}

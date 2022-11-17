package com.example.demo.service;

import com.example.demo.model.Server;

import java.io.IOException;
import java.util.Collection;

public interface ServerService {
    Server create(Server server);
    Collection<Server> list(int limit);
    Server get(Long id);
    Boolean delete(Long id);

    int test();
}

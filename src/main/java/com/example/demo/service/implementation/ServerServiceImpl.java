package com.example.demo.service.implementation;

import com.example.demo.model.Server;
import com.example.demo.repo.ServerRepo;
import com.example.demo.service.ServerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ServerServiceImpl implements ServerService {
    private final ServerRepo serverRepo;
    @Override
    public Server create(Server server) {
        log.info("Saving new person:{}",server.getNombres());
        return serverRepo.save(server);
    }

    @Override
    public Collection<Server> list(int limit) {
        log.info("Fetching all servers");
        return serverRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Server get(Long id) {
        log.info("Fetching server by id: {}",id);
        return serverRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting server by ID:{}", id);
        serverRepo.deleteById(id);
        return TRUE;
    }

    @Override
    public int test() {

        return serverRepo.total();
    }

}

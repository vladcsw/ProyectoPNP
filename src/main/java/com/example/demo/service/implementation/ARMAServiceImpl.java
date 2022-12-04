package com.example.demo.service.implementation;

import com.example.demo.model.ARMA;
import com.example.demo.repo.ARMARepo;
import com.example.demo.service.ARMAService;
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
public class ARMAServiceImpl implements ARMAService {

    private final ARMARepo armaRepo;
    @Override
    public ARMA create(ARMA arma) {
        log.info("Saving new arma:{}",arma.getId());
        return armaRepo.save(arma);
    }

    @Override
    public Collection<ARMA> list(int limit) {
        log.info("Fetching all arma");
        return armaRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public ARMA get(Long id) {
        log.info("Fetching arma by id: {}",id);
        return armaRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting arma by ID:{}", id);
        armaRepo.deleteById(id);
        return TRUE;
    }
}

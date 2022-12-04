package com.example.demo.service.implementation;

import com.example.demo.model.CUENTA_BANCARIA;
import com.example.demo.repo.CUENTA_BANCARIARepo;
import com.example.demo.service.CUENTA_BANCARIAService;
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
public class CUENTA_BANCARIAServiceImpl implements CUENTA_BANCARIAService {

    private final CUENTA_BANCARIARepo cuenta_bancariaRepo;
    @Override
    public CUENTA_BANCARIA create(CUENTA_BANCARIA cuenta_bancaria) {
        log.info("Saving new cuenta_bancaria:{}",cuenta_bancaria.getId());
        return cuenta_bancariaRepo.save(cuenta_bancaria);
    }

    @Override
    public Collection<CUENTA_BANCARIA> list(int limit) {
        log.info("Fetching all cuenta_bancaria");
        return cuenta_bancariaRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public CUENTA_BANCARIA get(Long id) {
        log.info("Fetching cuenta_bancaria by id: {}",id);
        return cuenta_bancariaRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting cuenta_bancaria by ID:{}", id);
        cuenta_bancariaRepo.deleteById(id);
        return TRUE;
    }
}

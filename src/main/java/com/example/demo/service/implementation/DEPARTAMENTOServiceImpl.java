package com.example.demo.service.implementation;

import com.example.demo.model.DEPARTAMENTO;
import com.example.demo.repo.DEPARTAMENTORepo;
import com.example.demo.service.DEPARTAMENTOService;
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
public class DEPARTAMENTOServiceImpl implements DEPARTAMENTOService {

    private final DEPARTAMENTORepo departamentoRepo;
    @Override
    public DEPARTAMENTO create(DEPARTAMENTO departamento) {
        log.info("Saving new departamento:{}",departamento.getId());
        return departamentoRepo.save(departamento);
    }

    @Override
    public Collection<DEPARTAMENTO> list(int limit) {
        log.info("Fetching all departamento");
        return departamentoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public DEPARTAMENTO get(Long id) {
        log.info("Fetching departamento by id: {}",id);
        return departamentoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting departamento by ID:{}", id);
        departamentoRepo.deleteById(id);
        return TRUE;
    }
}

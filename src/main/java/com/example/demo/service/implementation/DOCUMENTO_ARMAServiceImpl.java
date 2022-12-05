package com.example.demo.service.implementation;

import com.example.demo.model.DOCUMENTO_ARMA;
import com.example.demo.repo.DOCUMENTO_ARMARepo;
import com.example.demo.service.DOCUMENTO_ARMAService;
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
public class DOCUMENTO_ARMAServiceImpl implements DOCUMENTO_ARMAService {

    private final DOCUMENTO_ARMARepo documento_armaRepo;
    @Override
    public DOCUMENTO_ARMA create(DOCUMENTO_ARMA documento_arma) {
        log.info("Saving new documento_arma:{}",documento_arma.getId());
        return documento_armaRepo.save(documento_arma);
    }

    @Override
    public Collection<DOCUMENTO_ARMA> list(int limit) {
        log.info("Fetching all documento_arma");
        return documento_armaRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public DOCUMENTO_ARMA get(Long id) {
        log.info("Fetching documento_arma by id: {}",id);
        return documento_armaRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting documento_arma by ID:{}", id);
        documento_armaRepo.deleteById(id);
        return TRUE;
    }
    public Collection<DOCUMENTO_ARMA> byDocumento(Long id) {
        log.info("byDocumento:{}", id);
        return documento_armaRepo.ByDocumentoId(id);
    }
}

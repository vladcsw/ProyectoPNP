package com.example.demo.service.implementation;

import com.example.demo.model.DOCUMENTO_CUENTA_BANCARIA;
import com.example.demo.repo.DOCUMENTO_CUENTA_BANCARIARepo;
import com.example.demo.service.DOCUMENTO_CUENTA_BANCARIAService;
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
public class DOCUMENTO_CUENTA_BANCARIAServiceImpl implements DOCUMENTO_CUENTA_BANCARIAService {

    private final DOCUMENTO_CUENTA_BANCARIARepo documento_cuenta_bancariaRepo;
    @Override
    public DOCUMENTO_CUENTA_BANCARIA create(DOCUMENTO_CUENTA_BANCARIA documento_cuenta_bancaria) {
        log.info("Saving new documento_cuenta_bancaria:{}",documento_cuenta_bancaria.getId());
        return documento_cuenta_bancariaRepo.save(documento_cuenta_bancaria);
    }

    @Override
    public Collection<DOCUMENTO_CUENTA_BANCARIA> list(int limit) {
        log.info("Fetching all documento_cuenta_bancaria");
        return documento_cuenta_bancariaRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public DOCUMENTO_CUENTA_BANCARIA get(Long id) {
        log.info("Fetching documento_cuenta_bancaria by id: {}",id);
        return documento_cuenta_bancariaRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting documento_cuenta_bancaria by ID:{}", id);
        documento_cuenta_bancariaRepo.deleteById(id);
        return TRUE;
    }

    public Collection<DOCUMENTO_CUENTA_BANCARIA> byDocumento(Long id) {
        log.info("byDocumento:{}", id);
        return documento_cuenta_bancariaRepo.ByDocumentoId(id);
    }
}

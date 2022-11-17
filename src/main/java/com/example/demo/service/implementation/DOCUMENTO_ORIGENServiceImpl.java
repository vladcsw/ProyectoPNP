package com.example.demo.service.implementation;

import com.example.demo.model.DOCUMENTO_ORIGEN;
import com.example.demo.repo.DOCUMENTO_ORIGENRepo;
import com.example.demo.service.DOCUMENTO_ORIGENService;
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
public class DOCUMENTO_ORIGENServiceImpl implements DOCUMENTO_ORIGENService {

    private final DOCUMENTO_ORIGENRepo documento_origenRepo;
    @Override
    public DOCUMENTO_ORIGEN create(DOCUMENTO_ORIGEN documento_origen) {
        log.info("Saving new documento_origen:{}",documento_origen.getId());
        return documento_origenRepo.save(documento_origen);
    }

    @Override
    public Collection<DOCUMENTO_ORIGEN> list(int limit) {
        log.info("Fetching all documento_origen");
        return documento_origenRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public DOCUMENTO_ORIGEN get(Long id) {
        log.info("Fetching documento_origen by id: {}",id);
        return documento_origenRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting documento_origen by ID:{}", id);
        documento_origenRepo.deleteById(id);
        return TRUE;
    }
}
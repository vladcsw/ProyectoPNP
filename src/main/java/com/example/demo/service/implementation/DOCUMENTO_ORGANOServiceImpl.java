package com.example.demo.service.implementation;

import com.example.demo.model.DOCUMENTO_ORGANO;
import com.example.demo.repo.DOCUMENTO_ORGANORepo;
import com.example.demo.service.DOCUMENTO_ORGANOService;
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
public class DOCUMENTO_ORGANOServiceImpl implements DOCUMENTO_ORGANOService {

    private final DOCUMENTO_ORGANORepo documento_organoRepo;
    @Override
    public DOCUMENTO_ORGANO create(DOCUMENTO_ORGANO documento_organo) {
        log.info("Saving new documento_organo:{}",documento_organo.getId());
        return documento_organoRepo.save(documento_organo);
    }

    @Override
    public Collection<DOCUMENTO_ORGANO> list(int limit) {
        log.info("Fetching all documento_organo");
        return documento_organoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public DOCUMENTO_ORGANO get(Long id) {
        log.info("Fetching documento_organo by id: {}",id);
        return documento_organoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting documento_organo by ID:{}", id);
        documento_organoRepo.deleteById(id);
        return TRUE;
    }

}

package com.example.demo.service.implementation;

import com.example.demo.model.DOCUMENTO_CLASE;
import com.example.demo.repo.DOCUMENTO_CLASERepo;
import com.example.demo.service.DOCUMENTO_CLASEService;
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
public class DOCUMENTO_CLASEServiceImpl implements DOCUMENTO_CLASEService {

    private final DOCUMENTO_CLASERepo documento_claseRepo;
    @Override
    public DOCUMENTO_CLASE create(DOCUMENTO_CLASE documento_clase) {
        log.info("Saving new documento_clase:{}",documento_clase.getId());
        return documento_claseRepo.save(documento_clase);
    }

    @Override
    public Collection<DOCUMENTO_CLASE> list(int limit) {
        log.info("Fetching all documento_clase");
        return documento_claseRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public DOCUMENTO_CLASE get(Long id) {
        log.info("Fetching documento_clase by id: {}",id);
        return documento_claseRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting documento_clase by ID:{}", id);
        documento_claseRepo.deleteById(id);
        return TRUE;
    }
}

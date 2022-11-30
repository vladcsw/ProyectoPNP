package com.example.demo.service.implementation;

import com.example.demo.model.DOCUMENTO_TIPO;
import com.example.demo.repo.DOCUMENTO_TIPORepo;
import com.example.demo.service.DOCUMENTO_TIPOService;
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
public class DOCUMENTO_TIPOServiceImpl implements DOCUMENTO_TIPOService {

    private final DOCUMENTO_TIPORepo documento_tipoRepo;
    @Override
    public DOCUMENTO_TIPO create(DOCUMENTO_TIPO documento_tipo) {
        log.info("Saving new documento_tipo:{}",documento_tipo.getId());
        return documento_tipoRepo.save(documento_tipo);
    }

    @Override
    public Collection<DOCUMENTO_TIPO> list(int limit) {
        log.info("Fetching all documento_tipo");
        return documento_tipoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public DOCUMENTO_TIPO get(Long id) {
        log.info("Fetching documento_tipo by id: {}",id);
        return documento_tipoRepo.findById(id).orElse(null);
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting documento_tipo by ID:{}", id);
        documento_tipoRepo.deleteById(id);
        return TRUE;
    }
}

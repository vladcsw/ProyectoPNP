package com.example.demo.service.implementation;

import com.example.demo.model.DOCUMENTO_CLASE_TIPO;
import com.example.demo.repo.DOCUMENTO_CLASE_TIPORepo;
import com.example.demo.service.DOCUMENTO_CLASE_TIPOService;
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
public class DOCUMENTO_CLASE_TIPOServiceImpl implements DOCUMENTO_CLASE_TIPOService {

    private final DOCUMENTO_CLASE_TIPORepo documento_clase_tipoRepo;
    @Override
    public DOCUMENTO_CLASE_TIPO create(DOCUMENTO_CLASE_TIPO documento_clase_tipo) {
        log.info("Saving new documento_clase_tipo:{}",documento_clase_tipo.getId());
        return documento_clase_tipoRepo.save(documento_clase_tipo);
    }

    @Override
    public Collection<DOCUMENTO_CLASE_TIPO> list(int limit) {
        log.info("Fetching all documento_clase_tipo");
        return documento_clase_tipoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public DOCUMENTO_CLASE_TIPO get(Long id) {
        log.info("Fetching documento_clase_tipo by id: {}",id);
        return documento_clase_tipoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting documento_clase_tipo by ID:{}", id);
        documento_clase_tipoRepo.deleteById(id);
        return TRUE;
    }
}

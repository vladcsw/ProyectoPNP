package com.example.demo.service.implementation;

import com.example.demo.model.RELACION_TIPO;
import com.example.demo.repo.RELACION_TIPORepo;
import com.example.demo.service.RELACION_TIPOService;
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
public class RELACION_TIPOServiceImpl implements RELACION_TIPOService {

    private final RELACION_TIPORepo relacion_tipoRepo;
    @Override
    public RELACION_TIPO create(RELACION_TIPO relacion_tipo) {
        log.info("Saving new relacion_tipo:{}",relacion_tipo.getId());
        return relacion_tipoRepo.save(relacion_tipo);
    }

    @Override
    public Collection<RELACION_TIPO> list(int limit) {
        log.info("Fetching all relacion_tipo");
        return relacion_tipoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public RELACION_TIPO get(Long id) {
        log.info("Fetching relacion_tipo by id: {}",id);
        return relacion_tipoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting relacion_tipo by ID:{}", id);
        relacion_tipoRepo.deleteById(id);
        return TRUE;
    }
}

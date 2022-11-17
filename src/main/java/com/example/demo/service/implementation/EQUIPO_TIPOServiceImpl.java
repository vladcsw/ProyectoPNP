package com.example.demo.service.implementation;

import com.example.demo.model.EQUIPO_TIPO;
import com.example.demo.repo.EQUIPO_TIPORepo;
import com.example.demo.service.EQUIPO_TIPOService;
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
public class EQUIPO_TIPOServiceImpl implements EQUIPO_TIPOService {

    private final EQUIPO_TIPORepo equipo_tipoRepo;
    @Override
    public EQUIPO_TIPO create(EQUIPO_TIPO equipo_tipo) {
        log.info("Saving new equipo_tipo:{}",equipo_tipo.getId());
        return equipo_tipoRepo.save(equipo_tipo);
    }

    @Override
    public Collection<EQUIPO_TIPO> list(int limit) {
        log.info("Fetching all equipo_tipo");
        return equipo_tipoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public EQUIPO_TIPO get(Long id) {
        log.info("Fetching equipo_tipo by id: {}",id);
        return equipo_tipoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting equipo_tipo by ID:{}", id);
        equipo_tipoRepo.deleteById(id);
        return TRUE;
    }
}
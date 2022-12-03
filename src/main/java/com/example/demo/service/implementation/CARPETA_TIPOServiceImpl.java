package com.example.demo.service.implementation;

import com.example.demo.model.CARPETA_TIPO;
import com.example.demo.repo.CARPETA_TIPORepo;
import com.example.demo.service.CARPETA_TIPOService;
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
public class CARPETA_TIPOServiceImpl implements CARPETA_TIPOService {

    private final CARPETA_TIPORepo carpeta_tipoRepo;
    @Override
    public CARPETA_TIPO create(CARPETA_TIPO carpeta_tipo) {
        log.info("Saving new carpeta_tipo:{}",carpeta_tipo.getId());

        return carpeta_tipoRepo.save(carpeta_tipo);
    }

    @Override
    public Collection<CARPETA_TIPO> list(int limit) {
        log.info("Fetching all carpeta_tipo");
        return carpeta_tipoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public CARPETA_TIPO get(Long id) {
        log.info("Fetching carpeta_tipo by id: {}",id);

        return carpeta_tipoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting carpeta_tipo by ID:{}", id);
        carpeta_tipoRepo.deleteById(id);
        return TRUE;
    }

}
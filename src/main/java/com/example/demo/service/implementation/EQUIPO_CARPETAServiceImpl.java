package com.example.demo.service.implementation;

import com.example.demo.model.EQUIPO_CARPETA;
import com.example.demo.repo.EQUIPO_CARPETARepo;
import com.example.demo.service.EQUIPO_CARPETAService;
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
public class EQUIPO_CARPETAServiceImpl implements EQUIPO_CARPETAService {

    private final EQUIPO_CARPETARepo equipo_carpetaRepo;
    @Override
    public EQUIPO_CARPETA create(EQUIPO_CARPETA equipo_carpeta) {
        log.info("Saving new equipo_carpeta:{}",equipo_carpeta.getId());
        return equipo_carpetaRepo.save(equipo_carpeta);
    }

    @Override
    public Collection<EQUIPO_CARPETA> list(int limit) {
        log.info("Fetching all equipo_carpeta");
        return equipo_carpetaRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public EQUIPO_CARPETA get(Long id) {
        log.info("Fetching equipo_carpeta by id: {}",id);
        return equipo_carpetaRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting equipo_carpeta by ID:{}", id);
        equipo_carpetaRepo.deleteById(id);
        return TRUE;
    }
}
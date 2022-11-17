package com.example.demo.service.implementation;

import com.example.demo.model.CARPETA_ORIGEN;
import com.example.demo.repo.CARPETA_ORIGENRepo;
import com.example.demo.service.CARPETA_ORIGENService;
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
public class CARPETA_ORIGENServiceImpl implements CARPETA_ORIGENService {

    private final CARPETA_ORIGENRepo carpeta_origenRepo;
    @Override
    public CARPETA_ORIGEN create(CARPETA_ORIGEN carpeta_origen) {
        log.info("Saving new carpeta_origen:{}",carpeta_origen.getId());
        return carpeta_origenRepo.save(carpeta_origen);
    }

    @Override
    public Collection<CARPETA_ORIGEN> list(int limit) {
        log.info("Fetching all carpeta_origen");
        return carpeta_origenRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public CARPETA_ORIGEN get(Long id) {
        log.info("Fetching carpeta_origen by id: {}",id);
        return carpeta_origenRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting carpeta_origen by ID:{}", id);
        carpeta_origenRepo.deleteById(id);
        return TRUE;
    }
}
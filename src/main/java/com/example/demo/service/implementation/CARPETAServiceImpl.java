package com.example.demo.service.implementation;

import com.example.demo.model.CARPETA;
import com.example.demo.repo.CARPETARepo;
import com.example.demo.service.CARPETAService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class CARPETAServiceImpl implements CARPETAService {

    private final CARPETARepo carpetaRepo;
    @Override
    public CARPETA create(CARPETA carpeta) {
        log.info("Saving new carpeta:{}",carpeta.getId());
        carpeta.setFecha(LocalDate.now());
        LocalDateTime x = LocalDateTime.now();
        carpeta.setHora(x.getHour()+":"+x.getMinute()+":"+x.getSecond());
        return carpetaRepo.save(carpeta);
    }

    @Override
    public Collection<CARPETA> list(int limit) {
        log.info("Fetching all carpeta");
        return carpetaRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public CARPETA get(Long id) {
        log.info("Fetching carpeta by id: {}",id);
        return carpetaRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting carpeta by ID:{}", id);
        carpetaRepo.deleteById(id);
        return TRUE;
    }
}
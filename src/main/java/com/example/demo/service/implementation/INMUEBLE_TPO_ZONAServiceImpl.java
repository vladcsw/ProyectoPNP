package com.example.demo.service.implementation;

import com.example.demo.model.INMUEBLE_TPO_ZONA;
import com.example.demo.repo.INMUEBLE_TPO_ZONARepo;
import com.example.demo.service.INMUEBLE_TPO_ZONAService;
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
public class INMUEBLE_TPO_ZONAServiceImpl implements INMUEBLE_TPO_ZONAService {

    private final INMUEBLE_TPO_ZONARepo inmueble_tpo_zonaRepo;
    @Override
    public INMUEBLE_TPO_ZONA create(INMUEBLE_TPO_ZONA inmueble_tpo_zona) {
        log.info("Saving new inmueble_tpo_zona:{}",inmueble_tpo_zona.getId());
        return inmueble_tpo_zonaRepo.save(inmueble_tpo_zona);
    }

    @Override
    public Collection<INMUEBLE_TPO_ZONA> list(int limit) {
        log.info("Fetching all inmueble_tpo_zona");
        return inmueble_tpo_zonaRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public INMUEBLE_TPO_ZONA get(Long id) {
        log.info("Fetching inmueble_tpo_zona by id: {}",id);
        return inmueble_tpo_zonaRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting inmueble_tpo_zona by ID:{}", id);
        inmueble_tpo_zonaRepo.deleteById(id);
        return TRUE;
    }
}

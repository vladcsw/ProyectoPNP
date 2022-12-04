package com.example.demo.service.implementation;

import com.example.demo.model.INMUEBLE_TIPO;
import com.example.demo.repo.INMUEBLE_TIPORepo;
import com.example.demo.service.INMUEBLE_TIPOService;
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
public class INMUEBLE_TIPOServiceImpl implements INMUEBLE_TIPOService {

    private final INMUEBLE_TIPORepo inmueble_tipoRepo;
    @Override
    public INMUEBLE_TIPO create(INMUEBLE_TIPO inmueble_tipo) {
        log.info("Saving new inmueble_tipo:{}",inmueble_tipo.getId());
        return inmueble_tipoRepo.save(inmueble_tipo);
    }

    @Override
    public Collection<INMUEBLE_TIPO> list(int limit) {
        log.info("Fetching all inmueble_tipo");
        return inmueble_tipoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public INMUEBLE_TIPO get(Long id) {
        log.info("Fetching inmueble_tipo by id: {}",id);
        return inmueble_tipoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting inmueble_tipo by ID:{}", id);
        inmueble_tipoRepo.deleteById(id);
        return TRUE;
    }
}

package com.example.demo.service.implementation;

import com.example.demo.model.RELACION_ORIGEN;
import com.example.demo.repo.RELACION_ORIGENRepo;
import com.example.demo.service.RELACION_ORIGENService;
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
public class RELACION_ORIGENServiceImpl implements RELACION_ORIGENService {

    private final RELACION_ORIGENRepo relacion_origenRepo;
    @Override
    public RELACION_ORIGEN create(RELACION_ORIGEN relacion_origen) {
        log.info("Saving new relacion_origen:{}",relacion_origen.getId());
        return relacion_origenRepo.save(relacion_origen);
    }

    @Override
    public Collection<RELACION_ORIGEN> list(int limit) {
        log.info("Fetching all relacion_origen");
        return relacion_origenRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public RELACION_ORIGEN get(Long id) {
        log.info("Fetching relacion_origen by id: {}",id);
        return relacion_origenRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting relacion_origen by ID:{}", id);
        relacion_origenRepo.deleteById(id);
        return TRUE;
    }
}

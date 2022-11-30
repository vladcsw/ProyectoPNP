package com.example.demo.service.implementation;

import com.example.demo.model.EQUIPO_DOCUMENTO;
import com.example.demo.repo.EQUIPO_DOCUMENTORepo;
import com.example.demo.service.EQUIPO_DOCUMENTOService;
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
public class EQUIPO_DOCUMENTOServiceImpl implements EQUIPO_DOCUMENTOService {

    private final EQUIPO_DOCUMENTORepo equipo_documentoRepo;
    @Override
    public EQUIPO_DOCUMENTO create(EQUIPO_DOCUMENTO equipo_documento) {
        log.info("Saving new equipo_documento:{}",equipo_documento.getId());
        return equipo_documentoRepo.save(equipo_documento);
    }

    @Override
    public Collection<EQUIPO_DOCUMENTO> list(int limit) {
        log.info("Fetching all equipo_documento");
        return equipo_documentoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public EQUIPO_DOCUMENTO get(Long id) {
        log.info("Fetching equipo_documento by id: {}",id);
        return equipo_documentoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting equipo_documento by ID:{}", id);
        equipo_documentoRepo.deleteById(id);
        return TRUE;
    }
}

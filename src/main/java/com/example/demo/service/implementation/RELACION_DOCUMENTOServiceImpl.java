package com.example.demo.service.implementation;

import com.example.demo.model.RELACION_DOCUMENTO;
import com.example.demo.repo.RELACION_DOCUMENTORepo;
import com.example.demo.service.RELACION_DOCUMENTOService;
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
public class RELACION_DOCUMENTOServiceImpl implements RELACION_DOCUMENTOService {

    private final RELACION_DOCUMENTORepo relacion_documentoRepo;
    @Override
    public RELACION_DOCUMENTO create(RELACION_DOCUMENTO relacion_documento) {
        log.info("Saving new relacion_documento:{}",relacion_documento.getId());
        return relacion_documentoRepo.save(relacion_documento);
    }

    @Override
    public Collection<RELACION_DOCUMENTO> list(int limit) {
        log.info("Fetching all relacion_documento");
        return relacion_documentoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public RELACION_DOCUMENTO get(Long id) {
        log.info("Fetching relacion_documento by id: {}",id);
        return relacion_documentoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting relacion_documento by ID:{}", id);
        relacion_documentoRepo.deleteById(id);
        return TRUE;
    }
}

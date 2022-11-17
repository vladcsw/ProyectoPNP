package com.example.demo.service.implementation;

import com.example.demo.model.CARPETA_DOCUMENTO;
import com.example.demo.repo.CARPETA_DOCUMENTORepo;
import com.example.demo.service.CARPETA_DOCUMENTOService;
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
public class CARPETA_DOCUMENTOServiceImpl implements CARPETA_DOCUMENTOService {

    private final CARPETA_DOCUMENTORepo carpeta_documentoRepo;
    @Override
    public CARPETA_DOCUMENTO create(CARPETA_DOCUMENTO carpeta_documento) {
        log.info("Saving new carpeta_documento:{}",carpeta_documento.getId());
        return carpeta_documentoRepo.save(carpeta_documento);
    }

    @Override
    public Collection<CARPETA_DOCUMENTO> list(int limit) {
        log.info("Fetching all carpeta_documento");
        return carpeta_documentoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public CARPETA_DOCUMENTO get(Long id) {
        log.info("Fetching carpeta_documento by id: {}",id);
        return carpeta_documentoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting carpeta_documento by ID:{}", id);
        carpeta_documentoRepo.deleteById(id);
        return TRUE;
    }
}

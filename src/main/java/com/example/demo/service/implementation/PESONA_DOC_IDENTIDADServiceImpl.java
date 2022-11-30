package com.example.demo.service.implementation;

import com.example.demo.model.PESONA_DOC_IDENTIDAD;
import com.example.demo.repo.PESONA_DOC_IDENTIDADRepo;
import com.example.demo.service.PESONA_DOC_IDENTIDADService;
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
public class PESONA_DOC_IDENTIDADServiceImpl implements PESONA_DOC_IDENTIDADService {

    private final PESONA_DOC_IDENTIDADRepo pesona_doc_identidadRepo;
    @Override
    public PESONA_DOC_IDENTIDAD create(PESONA_DOC_IDENTIDAD pesona_doc_identidad) {
        log.info("Saving new pesona_doc_identidad:{}",pesona_doc_identidad.getId());
        return pesona_doc_identidadRepo.save(pesona_doc_identidad);
    }

    @Override
    public Collection<PESONA_DOC_IDENTIDAD> list(int limit) {
        log.info("Fetching all pesona_doc_identidad");
        return pesona_doc_identidadRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public PESONA_DOC_IDENTIDAD get(Long id) {
        log.info("Fetching pesona_doc_identidad by id: {}",id);
        return pesona_doc_identidadRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting pesona_doc_identidad by ID:{}", id);
        pesona_doc_identidadRepo.deleteById(id);
        return TRUE;
    }
}

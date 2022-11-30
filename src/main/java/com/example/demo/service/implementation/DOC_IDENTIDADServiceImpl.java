package com.example.demo.service.implementation;

import com.example.demo.model.DOC_IDENTIDAD;
import com.example.demo.repo.DOC_IDENTIDADRepo;
import com.example.demo.service.DOC_IDENTIDADService;
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
public class DOC_IDENTIDADServiceImpl implements DOC_IDENTIDADService {

    private final DOC_IDENTIDADRepo doc_identidadRepo;
    @Override
    public DOC_IDENTIDAD create(DOC_IDENTIDAD doc_identidad) {
        log.info("Saving new doc_identidad:{}",doc_identidad.getId());
        return doc_identidadRepo.save(doc_identidad);
    }

    @Override
    public Collection<DOC_IDENTIDAD> list(int limit) {
        log.info("Fetching all doc_identidad");
        return doc_identidadRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public DOC_IDENTIDAD get(Long id) {
        log.info("Fetching doc_identidad by id: {}",id);
        return doc_identidadRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting doc_identidad by ID:{}", id);
        doc_identidadRepo.deleteById(id);
        return TRUE;
    }
}

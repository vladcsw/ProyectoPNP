package com.example.demo.service.implementation;

import com.example.demo.model.DOCUMENTO_AGENDA;
import com.example.demo.repo.DOCUMENTO_AGENDARepo;
import com.example.demo.service.DOCUMENTO_AGENDAService;
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
public class DOCUMENTO_AGENDAServiceImpl implements DOCUMENTO_AGENDAService {

    private final DOCUMENTO_AGENDARepo documento_agendaRepo;
    @Override
    public DOCUMENTO_AGENDA create(DOCUMENTO_AGENDA documento_agenda) {
        log.info("Saving new documento_agenda:{}",documento_agenda.getId());
        return documento_agendaRepo.save(documento_agenda);
    }

    @Override
    public Collection<DOCUMENTO_AGENDA> list(int limit) {
        log.info("Fetching all documento_agenda");
        return documento_agendaRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public DOCUMENTO_AGENDA get(Long id) {
        log.info("Fetching documento_agenda by id: {}",id);
        return documento_agendaRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting documento_agenda by ID:{}", id);
        documento_agendaRepo.deleteById(id);
        return TRUE;
    }

    public Collection<DOCUMENTO_AGENDA> byDocumento(Long id) {
        log.info("byDocumento:{}", id);
        return documento_agendaRepo.ByDocumentoId(id);
    }
}

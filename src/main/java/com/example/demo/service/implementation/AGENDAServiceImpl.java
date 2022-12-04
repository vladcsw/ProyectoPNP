package com.example.demo.service.implementation;

import com.example.demo.model.AGENDA;
import com.example.demo.repo.AGENDARepo;
import com.example.demo.service.AGENDAService;
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
public class AGENDAServiceImpl implements AGENDAService {

    private final AGENDARepo agendaRepo;
    @Override
    public AGENDA create(AGENDA agenda) {
        log.info("Saving new agenda:{}",agenda.getId());
        return agendaRepo.save(agenda);
    }

    @Override
    public Collection<AGENDA> list(int limit) {
        log.info("Fetching all agenda");
        return agendaRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public AGENDA get(Long id) {
        log.info("Fetching agenda by id: {}",id);
        return agendaRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting agenda by ID:{}", id);
        agendaRepo.deleteById(id);
        return TRUE;
    }
}

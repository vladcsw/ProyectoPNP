package com.example.demo.service.implementation;

import com.example.demo.model.DISTRITO;
import com.example.demo.repo.DISTRITORepo;
import com.example.demo.service.DISTRITOService;
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
public class DISTRITOServiceImpl implements DISTRITOService {

    private final DISTRITORepo distritoRepo;
    @Override
    public DISTRITO create(DISTRITO distrito) {
        log.info("Saving new distrito:{}",distrito.getId());
        return distritoRepo.save(distrito);
    }

    @Override
    public Collection<DISTRITO> list(int limit) {
        log.info("Fetching all distrito");
        return distritoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public DISTRITO get(Long id) {
        log.info("Fetching distrito by id: {}",id);
        return distritoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting distrito by ID:{}", id);
        distritoRepo.deleteById(id);
        return TRUE;
    }
}

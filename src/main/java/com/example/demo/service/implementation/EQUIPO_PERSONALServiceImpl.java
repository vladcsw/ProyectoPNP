package com.example.demo.service.implementation;

import com.example.demo.model.EQUIPO_PERSONAL;
import com.example.demo.repo.EQUIPO_PERSONALRepo;
import com.example.demo.service.EQUIPO_PERSONALService;
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
public class EQUIPO_PERSONALServiceImpl implements EQUIPO_PERSONALService {

    private final EQUIPO_PERSONALRepo equipo_personalRepo;
    @Override
    public EQUIPO_PERSONAL create(EQUIPO_PERSONAL equipo_personal) {
        log.info("Saving new equipo_personal:{}",equipo_personal.getId());
        return equipo_personalRepo.save(equipo_personal);
    }

    @Override
    public Collection<EQUIPO_PERSONAL> list(int limit) {
        log.info("Fetching all equipo_personal");
        return equipo_personalRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public EQUIPO_PERSONAL get(Long id) {
        log.info("Fetching equipo_personal by id: {}",id);
        return equipo_personalRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting equipo_personal by ID:{}", id);
        equipo_personalRepo.deleteById(id);
        return TRUE;
    }
}
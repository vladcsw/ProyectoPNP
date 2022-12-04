package com.example.demo.service.implementation;

import com.example.demo.model.TELEFONO_EQUIPO;
import com.example.demo.repo.TELEFONO_EQUIPORepo;
import com.example.demo.service.TELEFONO_EQUIPOService;
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
public class TELEFONO_EQUIPOServiceImpl implements TELEFONO_EQUIPOService {

    private final TELEFONO_EQUIPORepo telefono_equipoRepo;
    @Override
    public TELEFONO_EQUIPO create(TELEFONO_EQUIPO telefono_equipo) {
        log.info("Saving new telefono_equipo:{}",telefono_equipo.getId());
        return telefono_equipoRepo.save(telefono_equipo);
    }

    @Override
    public Collection<TELEFONO_EQUIPO> list(int limit) {
        log.info("Fetching all telefono_equipo");
        return telefono_equipoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public TELEFONO_EQUIPO get(Long id) {
        log.info("Fetching telefono_equipo by id: {}",id);
        return telefono_equipoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting telefono_equipo by ID:{}", id);
        telefono_equipoRepo.deleteById(id);
        return TRUE;
    }
}

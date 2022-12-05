package com.example.demo.service.implementation;

import com.example.demo.model.DOCUMENTO_TELEFONO_EQUIPO;
import com.example.demo.repo.DOCUMENTO_TELEFONO_EQUIPORepo;
import com.example.demo.service.DOCUMENTO_TELEFONO_EQUIPOService;
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
public class DOCUMENTO_TELEFONO_EQUIPOServiceImpl implements DOCUMENTO_TELEFONO_EQUIPOService {

    private final DOCUMENTO_TELEFONO_EQUIPORepo documento_telefono_equipoRepo;
    @Override
    public DOCUMENTO_TELEFONO_EQUIPO create(DOCUMENTO_TELEFONO_EQUIPO documento_telefono_equipo) {
        log.info("Saving new documento_telefono_equipo:{}",documento_telefono_equipo.getId());
        return documento_telefono_equipoRepo.save(documento_telefono_equipo);
    }

    @Override
    public Collection<DOCUMENTO_TELEFONO_EQUIPO> list(int limit) {
        log.info("Fetching all documento_telefono_equipo");
        return documento_telefono_equipoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public DOCUMENTO_TELEFONO_EQUIPO get(Long id) {
        log.info("Fetching documento_telefono_equipo by id: {}",id);
        return documento_telefono_equipoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting documento_telefono_equipo by ID:{}", id);
        documento_telefono_equipoRepo.deleteById(id);
        return TRUE;
    }

    public Collection<DOCUMENTO_TELEFONO_EQUIPO> byDocumento(Long id) {
        log.info("byDocumento:{}", id);
        return documento_telefono_equipoRepo.ByDocumentoId(id);
    }
}

package com.example.demo.service.implementation;

import com.example.demo.model.OBJETO_MARCA;
import com.example.demo.repo.OBJETO_MARCARepo;
import com.example.demo.service.OBJETO_MARCAService;
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
public class OBJETO_MARCAServiceImpl implements OBJETO_MARCAService {

    private final OBJETO_MARCARepo objeto_marcaRepo;
    @Override
    public OBJETO_MARCA create(OBJETO_MARCA objeto_marca) {
        log.info("Saving new objeto_marca:{}",objeto_marca.getId());
        return objeto_marcaRepo.save(objeto_marca);
    }

    @Override
    public Collection<OBJETO_MARCA> list(int limit) {
        log.info("Fetching all objeto_marca");
        return objeto_marcaRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public OBJETO_MARCA get(Long id) {
        log.info("Fetching objeto_marca by id: {}",id);
        return objeto_marcaRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting objeto_marca by ID:{}", id);
        objeto_marcaRepo.deleteById(id);
        return TRUE;
    }
}
package com.example.demo.service.implementation;

import com.example.demo.model.PROVINCIA;
import com.example.demo.repo.PROVINCIARepo;
import com.example.demo.service.PROVINCIAService;
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
public class PROVINCIAServiceImpl implements PROVINCIAService {

    private final PROVINCIARepo provinciaRepo;
    @Override
    public PROVINCIA create(PROVINCIA provincia) {
        log.info("Saving new provincia:{}",provincia.getId());
        return provinciaRepo.save(provincia);
    }

    @Override
    public Collection<PROVINCIA> list(int limit) {
        log.info("Fetching all provincia");
        return provinciaRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public PROVINCIA get(Long id) {
        log.info("Fetching provincia by id: {}",id);
        return provinciaRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting provincia by ID:{}", id);
        provinciaRepo.deleteById(id);
        return TRUE;
    }
}

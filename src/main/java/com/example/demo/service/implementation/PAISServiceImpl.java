package com.example.demo.service.implementation;

import com.example.demo.model.PAIS;
import com.example.demo.repo.PAISRepo;
import com.example.demo.service.PAISService;
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
public class PAISServiceImpl implements PAISService {

    private final PAISRepo paisRepo;
    @Override
    public PAIS create(PAIS pais) {
        log.info("Saving new pais:{}",pais.getId());
        return paisRepo.save(pais);
    }

    @Override
    public Collection<PAIS> list(int limit) {
        log.info("Fetching all pais");
        return paisRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public PAIS get(Long id) {
        log.info("Fetching pais by id: {}",id);
        return paisRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting pais by ID:{}", id);
        paisRepo.deleteById(id);
        return TRUE;
    }
}

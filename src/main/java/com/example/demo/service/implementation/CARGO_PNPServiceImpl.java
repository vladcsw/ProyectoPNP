package com.example.demo.service.implementation;

import com.example.demo.model.CARGO_PNP;
import com.example.demo.repo.CARGO_PNPRepo;
import com.example.demo.service.CARGO_PNPService;
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
public class CARGO_PNPServiceImpl implements CARGO_PNPService {

    private final CARGO_PNPRepo cargo_pnpRepo;
    @Override
    public CARGO_PNP create(CARGO_PNP cargo_pnp) {
        log.info("Saving new cargo_pnp:{}",cargo_pnp.getId());
        return cargo_pnpRepo.save(cargo_pnp);
    }

    @Override
    public Collection<CARGO_PNP> list(int limit) {
        log.info("Fetching all cargo_pnp");
        return cargo_pnpRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public CARGO_PNP get(Long id) {
        log.info("Fetching cargo_pnp by id: {}",id);
        return cargo_pnpRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting cargo_pnp by ID:{}", id);
        cargo_pnpRepo.deleteById(id);
        return TRUE;
    }
}

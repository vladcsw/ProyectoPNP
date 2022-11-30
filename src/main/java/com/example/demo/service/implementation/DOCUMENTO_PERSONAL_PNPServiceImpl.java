package com.example.demo.service.implementation;

import com.example.demo.model.DOCUMENTO_PERSONAL_PNP;
import com.example.demo.repo.DOCUMENTO_PERSONAL_PNPRepo;
import com.example.demo.service.DOCUMENTO_PERSONAL_PNPService;
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
public class DOCUMENTO_PERSONAL_PNPServiceImpl implements DOCUMENTO_PERSONAL_PNPService {

    private final DOCUMENTO_PERSONAL_PNPRepo documento_personal_pnpRepo;
    @Override
    public DOCUMENTO_PERSONAL_PNP create(DOCUMENTO_PERSONAL_PNP documento_personal_pnp) {
        log.info("Saving new documento_personal_pnp:{}",documento_personal_pnp.getId());
        return documento_personal_pnpRepo.save(documento_personal_pnp);
    }

    @Override
    public Collection<DOCUMENTO_PERSONAL_PNP> list(int limit) {
        log.info("Fetching all documento_personal_pnp");
        return documento_personal_pnpRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public DOCUMENTO_PERSONAL_PNP get(Long id) {
        log.info("Fetching documento_personal_pnp by id: {}",id);
        return documento_personal_pnpRepo.findById(id).orElse(null);
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting documento_personal_pnp by ID:{}", id);
        documento_personal_pnpRepo.deleteById(id);
        return TRUE;
    }
}

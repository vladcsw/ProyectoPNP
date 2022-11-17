package com.example.demo.service.implementation;

import com.example.demo.model.PERSONAL_PNP;
import com.example.demo.model.PERSONAL_PNP;
import com.example.demo.repo.PERSONAL_PNPRepo;
import com.example.demo.service.PERSONAL_PNPService;
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
public class PERSONAL_PNPServiceImpl implements PERSONAL_PNPService {
    private final PERSONAL_PNPRepo personal_pnpRepo;
    @Override
    public PERSONAL_PNP create(PERSONAL_PNP personal_pnp) {
        return personal_pnpRepo.save(personal_pnp);
    }

    @Override
    public Collection<PERSONAL_PNP> list(int limit) {
        return personal_pnpRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public PERSONAL_PNP get(Long id) {
        return personal_pnpRepo.findById(id).get();
    }

    @Override
    public Boolean delete(Long id) {
        personal_pnpRepo.deleteById(id);
        return TRUE;
    }
}

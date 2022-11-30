package com.example.demo.service.implementation;

import com.example.demo.model.PEDIDO;
import com.example.demo.repo.PEDIDORepo;
import com.example.demo.service.PEDIDOService;
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
public class PEDIDOServiceImpl implements PEDIDOService {

    private final PEDIDORepo pedidoRepo;
    @Override
    public PEDIDO create(PEDIDO pedido) {
        log.info("Saving new pedido:{}",pedido.getId());
        return pedidoRepo.save(pedido);
    }

    @Override
    public Collection<PEDIDO> list(int limit) {
        log.info("Fetching all pedido");
        return pedidoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public PEDIDO get(Long id) {
        log.info("Fetching pedido by id: {}",id);
        return pedidoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting pedido by ID:{}", id);
        pedidoRepo.deleteById(id);
        return TRUE;
    }
}

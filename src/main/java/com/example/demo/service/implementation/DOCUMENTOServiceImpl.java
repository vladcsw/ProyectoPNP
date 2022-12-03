package com.example.demo.service.implementation;

import com.example.demo.model.DOCUMENTO;
import com.example.demo.model.DOCUMENTO;
import com.example.demo.repo.DOCUMENTORepo;
import com.example.demo.service.DOCUMENTOService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class DOCUMENTOServiceImpl implements DOCUMENTOService {
    private final DOCUMENTORepo documentoRepo;
    @Override
    public DOCUMENTO create(DOCUMENTO documento) {
        documento.setCodigo(documento.getDescripcion()+ LocalDate.now());
        documento.setTipoDocumento("NOTA DE AGENTE");
        documento.setCodigo("SIPA-"+LocalDate.now().format(DateTimeFormatter.ofPattern("ddMMYYYY"))+'-'+documentoRepo.count());
        documento.setSituacion("URGENTE");
        documento.setInstructor("USUARIO");
        documento.setDisposicion(1);
        return documentoRepo.save(documento);



    }

    @Override
    public Collection<DOCUMENTO> list(int limit) {
        return documentoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public DOCUMENTO get(Long id) {
        return documentoRepo.findById(id).get();
    }

    @Override
    public Boolean delete(Long id) {
        documentoRepo.deleteById(id);
        return TRUE;
    }

    public void detach(Long id) {
        documentoRepo.papelera(id);
    }

    public Collection<DOCUMENTO> listestadonormal() {
        return documentoRepo.findAllBydisposicion(1);
    }
    public Collection<DOCUMENTO> listestadoanulado() {
        return documentoRepo.findAllBydisposicion(2);
    }

}

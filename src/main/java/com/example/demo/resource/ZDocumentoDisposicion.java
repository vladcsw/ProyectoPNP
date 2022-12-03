package com.example.demo.resource;

import com.example.demo.model.DOCUMENTO;
import com.example.demo.model.DOCUMENTO_PERSONA;
import com.example.demo.repo.DOCUMENTORepo;
import com.example.demo.service.implementation.DOCUMENTOServiceImpl;
import com.example.demo.service.implementation.RELACION_TIPOServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/documento")
@RequiredArgsConstructor
public class ZDocumentoDisposicion {
    private final DOCUMENTOServiceImpl a;

    @GetMapping("/mandar_papelera/{id}")
    public void papelera(@PathVariable("id") Long id){
        a.detach(id);
    }

    @GetMapping("/normal")
    public Collection<DOCUMENTO> normal(){
        return a.listestadonormal();
    }

    @GetMapping("/papelera")
    public Collection<DOCUMENTO> papelera(){
        return a.listestadoanulado();
    }

}

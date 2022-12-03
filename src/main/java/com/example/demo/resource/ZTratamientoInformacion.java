package com.example.demo.resource;

import com.example.demo.model.*;
import com.example.demo.service.implementation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/tratamiento")
@RequiredArgsConstructor
public class ZTratamientoInformacion{

    private final DOCUMENTO_PERSONAServiceImpl documento_personaService;
    private final DOCUMENTO_INMUEBLEServiceImpl documento_inmuebleService;
    private final DOCUMENTO_EMPRESAServiceImpl documento_empresaService;
    private final DOCUMENTO_VEHICULOServiceImpl documento_vehiculoService;
    private final DOCUMENTO_TELEFONOServiceImpl documento_telefonoService;

    @GetMapping("/persona/{id}")
    public Collection<DOCUMENTO_PERSONA> getPERSONA(@PathVariable("id") Long id){
        return documento_personaService.byDocumento(id);
    }

    @GetMapping("/inmueble/{id}")
    public Collection<DOCUMENTO_INMUEBLE> getINMUEBLE(@PathVariable("id") Long id){
        return documento_inmuebleService.byDocumento(id);
    }

    @GetMapping("/empresa/{id}")
    public Collection<DOCUMENTO_EMPRESA> getEMPRESA(@PathVariable("id") Long id){
        return documento_empresaService.byDocumento(id);
    }

    @GetMapping("/vehiculo/{id}")
    public Collection<DOCUMENTO_VEHICULO> getVEHICULO(@PathVariable("id") Long id){
        return documento_vehiculoService.byDocumento(id);
    }

    @GetMapping("/telefono/{id}")
    public Collection<DOCUMENTO_TELEFONO> getTELEFONO(@PathVariable("id") Long id){
        return documento_telefonoService.byDocumento(id);
    }

}

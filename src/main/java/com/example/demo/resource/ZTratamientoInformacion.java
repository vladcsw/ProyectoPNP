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
    private final DOCUMENTO_INSUMOServiceImpl insumoService;
    private final DOCUMENTO_ARMAServiceImpl documento_armaService;
    private final DOCUMENTO_CUENTA_BANCARIAServiceImpl documento_cuenta_bancariaService;
    private final DOCUMENTO_TELEFONO_EQUIPOServiceImpl documento_telefono_equipoService;
    private final DOCUMENTO_MODALIDADServiceImpl documento_modalidadService;
    private final DOCUMENTO_AGENDAServiceImpl documento_agendaService;
    private final PEDIDOServiceImpl pedidoService;

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
    @GetMapping("/insumo/{id}")
    public Collection<DOCUMENTO_INSUMO> getINSUMO(@PathVariable("id") Long id){
        return insumoService.byDocumento(id);
    }

    @GetMapping("/arma/{id}")
    public Collection<DOCUMENTO_ARMA> getarma(@PathVariable("id") Long id){
        return documento_armaService.byDocumento(id);
    }
    @GetMapping("/cuenta_bancaria/{id}")
    public Collection<DOCUMENTO_CUENTA_BANCARIA> getcuenta(@PathVariable("id") Long id){
        return documento_cuenta_bancariaService.byDocumento(id);
    }
    @GetMapping("/telefono_equipo/{id}")
    public Collection<DOCUMENTO_TELEFONO_EQUIPO> getTelefonoEquipo(@PathVariable("id") Long id){
        return documento_telefono_equipoService.byDocumento(id);
    }
    @GetMapping("/modalidad/{id}")
    public Collection<DOCUMENTO_MODALIDAD> getmodalidad(@PathVariable("id") Long id){
        return documento_modalidadService.byDocumento(id);
    }
    @GetMapping("/agenda/{id}")
    public Collection<DOCUMENTO_AGENDA> getagenda(@PathVariable("id") Long id){
        return documento_agendaService.byDocumento(id);
    }

    @GetMapping("/pedido/{id}")
    public Collection<PEDIDO> getPedido(@PathVariable("id") Long id){
        return pedidoService.byDocumento(id);
    }

    @GetMapping("/pedido/distinct/")
    public Collection<Long> getPedido(){
        return pedidoService.pedidos();
    }

}

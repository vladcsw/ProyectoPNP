package com.example.demo.resource;

import com.example.demo.model.*;
import com.example.demo.service.implementation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/documento")
@RequiredArgsConstructor
public class DOCUMENTOResource {
    private final DOCUMENTOServiceImpl documentoService;
    private final DOCUMENTO_CARACTERISTICAServiceImpl documento_caracteristicaService;
    private final DOCUMENTO_ESTADOServiceImpl documento_estadoService;
    private final DOCUMENTO_CLASIFICACIONServiceImpl documento_clasificacionService;
    private final DOCUMENTO_TIPOServiceImpl documento_tipoService;

    private final PRIORIDADServiceImpl prioridadService;

    @GetMapping("/list")
    public ResponseEntity<Response> getDOCUMENTOs() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("documentos",documentoService.list(30)))
                        .message("DOCUMENTOs retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<DOCUMENTO> getRELACION_PER_EMPRESAss()  {
        return documentoService.list(30);
    }

    @GetMapping("/getAll/{id}")
    public Collection<DOCUMENTO> getSimpleDEPARTAMENTO(@PathVariable("id") Collection<Long> id)  {
        return documentoService.getAll(id);
    }
    @PostMapping("/save")
    public ResponseEntity<Response> saveDOCUMENTO(@RequestBody @Valid DOCUMENTO documento) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("documento",documentoService.create(documento)))
                        .message("DOCUMENTO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getDOCUMENTO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("documento",documentoService.get(id)))
                        .message("DOCUMENTO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteDOCUMENTO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",documentoService.delete(id)))
                        .message("DOCUMENTO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/getx/{id}")
    public ResponseEntity<ResponseDocumento> getStringDocumento(@PathVariable("id") Long id){

        DOCUMENTO x = documentoService.get(id);
        Long idx = x.getId() != null ? x.getId() : 0;
        String descripcion = x.getDescripcion() != null ? x.getDescripcion() : "";
        String asunto = x.getAsunto() != null ? x.getAsunto() : "";
        String tipoDocumento = x.getTipoDocumento() != null ? x.getTipoDocumento() : "";
        String codigo = x.getCodigo() != null ? x.getCodigo() : "";
        LocalDate fecha = x.getFecha() != null ? x.getFecha() : LocalDate.of(1900,01,01);
        String obtencionInformacion = x.getObtencionInformacion() != null ? x.getObtencionInformacion() : "";
        String situacion = x.getSituacion() != null ? x.getSituacion() : "";
        String instructor = x.getInstructor() != null ? x.getInstructor() : "";
        int disposicion = x.getDisposicion() != 0 ? x.getDisposicion() : 0;

        //Maestros no existentes
        String detalle = "";
        String empresa = "";
        String origen = "";
        String persona = "";
        String tipo = "";
        //Maestros existentes
        String prioridad = "";
        String estado = "";
        String caracteristica = "";
        String clasificación = "";
        if(prioridadService.get((long) x.getDocumento_prioridad_id()) != null){
            prioridad = prioridadService.get((long) x.getDocumento_prioridad_id()).getDescripcion();
        }
        if(documento_estadoService.get((long) x.getDocumento_estado_id()) != null){
            estado = documento_estadoService.get((long) x.getDocumento_estado_id()).getDescripcion();
        }
        if(documento_caracteristicaService.get((long) x.getDocumento_caracteristica_id()) != null){
            caracteristica = documento_caracteristicaService.get((long) x.getDocumento_caracteristica_id()).getDescripcion();
        }
        if(documento_clasificacionService.get((long) x.getDocumento_clasificacion_id()) != null){
            clasificación = documento_clasificacionService.get((long) x.getDocumento_clasificacion_id()).getDescripcion();
        }

        return ResponseEntity.ok(
                ResponseDocumento.builder()
                        .id(idx)
                        .descripcion(descripcion)
                        .asunto(asunto)
                        .tipoDocumento(tipoDocumento)
                        .codigo(codigo)
                        .fecha(fecha)
                        .obtencionInformacion(obtencionInformacion)
                        .situacion(situacion)
                        .instructor(instructor)
                        .disposicion(disposicion)
                        .prioridad(prioridad)
                        .estado(estado)
                        .caracteristica(caracteristica)
                        .clasificacion(clasificación)
                        .detalle(detalle)
                        .empresa(empresa)
                        .origen(origen)
                        .persona(persona)
                        .tipo(tipo)
                        .build()
        );
    }

}

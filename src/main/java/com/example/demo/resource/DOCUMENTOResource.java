package com.example.demo.resource;

import com.example.demo.model.*;
import com.example.demo.service.implementation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
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

        String caracteristica = "";
        String clasificación = "";
        String estado = "";
        String tipo = "";
        String empresa = "";
        String origen = "";
        String persona = "";
        String detalle = "";
        String prioridad = "";
        if(documento_caracteristicaService.get((long) documentoService.get(id).getDocumento_caracteristica_id()) != null){
            caracteristica = documento_caracteristicaService.get((long) documentoService.get(id).getDocumento_caracteristica_id()).getDescripcion();
        }
        if(documento_clasificacionService.get((long) documentoService.get(id).getDocumento_caracteristica_id()) != null){
            clasificación = documento_clasificacionService.get((long) documentoService.get(id).getDocumento_clasificacion_id()).getDescripcion();
        }
        if(documento_estadoService.get((long) documentoService.get(id).getDocumento_caracteristica_id()) != null){
            estado = documento_estadoService.get((long) documentoService.get(id).getDocumento_estado_id()).getDescripcion();
        }
        if(documentoService.get(id).getTipoDocumento() != null){
            tipo =  documentoService.get(id).getTipoDocumento();
        }
        if(prioridadService.get((long) documentoService.get(id).getDocumento_caracteristica_id()) != null){
            prioridad = prioridadService.get((long) documentoService.get(id).getDocumento_prioridad_id()).getDescripcion();
        }

        return ResponseEntity.ok(
                ResponseDocumento.builder()
                        .caracteristica(caracteristica)
                        .clasificacion(clasificación)
                        .prioridad(prioridad)
                        .detalle(detalle)
                        .empresa(empresa)
                        .estado(estado)
                        .origen(origen)
                        .persona(persona)
                        .tipo(tipo)
                        .build()
        );
    }




}

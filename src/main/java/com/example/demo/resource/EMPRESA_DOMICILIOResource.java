package com.example.demo.resource;

import com.example.demo.model.DOMICILIO;
import com.example.demo.model.Response;
import com.example.demo.model.EMPRESA_DOMICILIO;
import com.example.demo.service.implementation.EMPRESA_DOMICILIOServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/empresa_domicilio")
@RequiredArgsConstructor
public class EMPRESA_DOMICILIOResource {
    private final EMPRESA_DOMICILIOServiceImpl empresa_domicilioService;
    @GetMapping("/list")
    public ResponseEntity<Response> getEMPRESA_DOMICILIOs() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("empresa_domicilios",empresa_domicilioService.list(30)))
                        .message("EMPRESA_DOMICILIOs retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<EMPRESA_DOMICILIO> getRELACION_PER_EMPRESAss()  {
        return empresa_domicilioService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveEMPRESA_DOMICILIO(@RequestBody @Valid EMPRESA_DOMICILIO empresa_domicilio) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("empresa_domicilio",empresa_domicilioService.create(empresa_domicilio)))
                        .message("EMPRESA_DOMICILIO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getEMPRESA_DOMICILIO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("empresa_domicilio",empresa_domicilioService.get(id)))
                        .message("EMPRESA_DOMICILIO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteEMPRESA_DOMICILIO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",empresa_domicilioService.delete(id)))
                        .message("EMPRESA_DOMICILIO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }



}

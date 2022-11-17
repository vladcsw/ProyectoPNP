package com.example.demo.resource;

import com.example.demo.model.EMPRESA_PERSONA;
import com.example.demo.model.Response;
import com.example.demo.model.EMPRESA;
import com.example.demo.service.implementation.EMPRESAServiceImpl;
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
@RequestMapping("/empresa")
@RequiredArgsConstructor
public class EMPRESAResource {
    private final EMPRESAServiceImpl empresaService;
    @GetMapping("/list")
    public ResponseEntity<Response> getEMPRESAs() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("empresas",empresaService.list(30)))
                        .message("EMPRESAs retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<EMPRESA> getRELACION_PER_EMPRESAss()  {
        return empresaService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveEMPRESA(@RequestBody @Valid EMPRESA empresa) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("empresa",empresaService.create(empresa)))
                        .message("EMPRESA created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getEMPRESA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("empresa",empresaService.get(id)))
                        .message("EMPRESA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteEMPRESA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",empresaService.delete(id)))
                        .message("EMPRESA deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }


}

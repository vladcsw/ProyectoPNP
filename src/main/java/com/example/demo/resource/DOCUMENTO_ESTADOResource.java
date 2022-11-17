package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.DOCUMENTO_ESTADO;
import com.example.demo.service.implementation.DOCUMENTO_ESTADOServiceImpl;
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
@RequestMapping("/documento_estado")
@RequiredArgsConstructor
public class DOCUMENTO_ESTADOResource {
    private final DOCUMENTO_ESTADOServiceImpl documento_estadoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getDOCUMENTO_ESTADO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_ESTADO",documento_estadoService.list(30)))
                        .message("DOCUMENTO_ESTADO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<DOCUMENTO_ESTADO> getSimpleDOCUMENTO_ESTADO()  {
        return documento_estadoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveDOCUMENTO_ESTADO(@RequestBody @Valid DOCUMENTO_ESTADO documento_estado) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_ESTADO",documento_estadoService.create(documento_estado)))
                        .message("DOCUMENTO_ESTADO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getDOCUMENTO_ESTADO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_ESTADO",documento_estadoService.get(id)))
                        .message("DOCUMENTO_ESTADO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteDOCUMENTO_ESTADO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",documento_estadoService.delete(id)))
                        .message("DOCUMENTO_ESTADO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.DOCUMENTO_EMPRESA;
import com.example.demo.service.implementation.DOCUMENTO_EMPRESAServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/documento_empresa")
@RequiredArgsConstructor
public class DOCUMENTO_EMPRESAResource {
    private final DOCUMENTO_EMPRESAServiceImpl documento_empresaService;
    @GetMapping("/list")
    public ResponseEntity<Response> getDOCUMENTO_EMPRESAs() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("documento_empresas",documento_empresaService.list(30)))
                        .message("DOCUMENTO_EMPRESAs retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveDOCUMENTO_EMPRESA(@RequestBody @Valid DOCUMENTO_EMPRESA documento_empresa) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("documento_empresa",documento_empresaService.create(documento_empresa)))
                        .message("DOCUMENTO_EMPRESA created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getDOCUMENTO_EMPRESA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("documento_empresa",documento_empresaService.get(id)))
                        .message("DOCUMENTO_EMPRESA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteDOCUMENTO_EMPRESA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",documento_empresaService.delete(id)))
                        .message("DOCUMENTO_EMPRESA deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }



}

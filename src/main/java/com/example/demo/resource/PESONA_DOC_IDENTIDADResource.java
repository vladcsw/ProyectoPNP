package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.PESONA_DOC_IDENTIDAD;
import com.example.demo.service.implementation.PESONA_DOC_IDENTIDADServiceImpl;
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
@RequestMapping("/pesona_doc_identidad")
@RequiredArgsConstructor
public class PESONA_DOC_IDENTIDADResource {
    private final PESONA_DOC_IDENTIDADServiceImpl pesona_doc_identidadService;
    @GetMapping("/list")
    public ResponseEntity<Response> getPESONA_DOC_IDENTIDAD() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("PESONA_DOC_IDENTIDAD",pesona_doc_identidadService.list(30)))
                        .message("PESONA_DOC_IDENTIDAD retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<PESONA_DOC_IDENTIDAD> getSimplePESONA_DOC_IDENTIDAD()  {
        return pesona_doc_identidadService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> savePESONA_DOC_IDENTIDAD(@RequestBody @Valid PESONA_DOC_IDENTIDAD pesona_doc_identidad) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("PESONA_DOC_IDENTIDAD",pesona_doc_identidadService.create(pesona_doc_identidad)))
                        .message("PESONA_DOC_IDENTIDAD created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getPESONA_DOC_IDENTIDAD(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("PESONA_DOC_IDENTIDAD",pesona_doc_identidadService.get(id)))
                        .message("PESONA_DOC_IDENTIDAD retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deletePESONA_DOC_IDENTIDAD(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",pesona_doc_identidadService.delete(id)))
                        .message("PESONA_DOC_IDENTIDAD deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

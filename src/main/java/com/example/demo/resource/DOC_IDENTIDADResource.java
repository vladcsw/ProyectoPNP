package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.DOC_IDENTIDAD;
import com.example.demo.service.implementation.DOC_IDENTIDADServiceImpl;
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
@RequestMapping("/doc_identidad")
@RequiredArgsConstructor
public class DOC_IDENTIDADResource {
    private final DOC_IDENTIDADServiceImpl doc_identidadService;
    @GetMapping("/list")
    public ResponseEntity<Response> getDOC_IDENTIDAD() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOC_IDENTIDAD",doc_identidadService.list(30)))
                        .message("DOC_IDENTIDAD retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<DOC_IDENTIDAD> getSimpleDOC_IDENTIDAD()  {
        return doc_identidadService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveDOC_IDENTIDAD(@RequestBody @Valid DOC_IDENTIDAD doc_identidad) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOC_IDENTIDAD",doc_identidadService.create(doc_identidad)))
                        .message("DOC_IDENTIDAD created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getDOC_IDENTIDAD(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOC_IDENTIDAD",doc_identidadService.get(id)))
                        .message("DOC_IDENTIDAD retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteDOC_IDENTIDAD(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",doc_identidadService.delete(id)))
                        .message("DOC_IDENTIDAD deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

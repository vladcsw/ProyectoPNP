package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.DOCUMENTO_CARACTERISTICA;
import com.example.demo.service.implementation.DOCUMENTO_CARACTERISTICAServiceImpl;
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
@RequestMapping("/documento_caracteristica")
@RequiredArgsConstructor
public class DOCUMENTO_CARACTERISTICAResource {
    private final DOCUMENTO_CARACTERISTICAServiceImpl documento_caracteristicaService;
    @GetMapping("/list")
    public ResponseEntity<Response> getDOCUMENTO_CARACTERISTICA() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_CARACTERISTICA",documento_caracteristicaService.list(30)))
                        .message("DOCUMENTO_CARACTERISTICA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<DOCUMENTO_CARACTERISTICA> getSimpleDOCUMENTO_CARACTERISTICA()  {
        return documento_caracteristicaService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveDOCUMENTO_CARACTERISTICA(@RequestBody @Valid DOCUMENTO_CARACTERISTICA documento_caracteristica) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_CARACTERISTICA",documento_caracteristicaService.create(documento_caracteristica)))
                        .message("DOCUMENTO_CARACTERISTICA created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getDOCUMENTO_CARACTERISTICA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_CARACTERISTICA",documento_caracteristicaService.get(id)))
                        .message("DOCUMENTO_CARACTERISTICA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteDOCUMENTO_CARACTERISTICA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",documento_caracteristicaService.delete(id)))
                        .message("DOCUMENTO_CARACTERISTICA deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.DOCUMENTO_MODALIDAD;
import com.example.demo.service.implementation.DOCUMENTO_MODALIDADServiceImpl;
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
@RequestMapping("/documento_modalidad")
@RequiredArgsConstructor
public class DOCUMENTO_MODALIDADResource {
    private final DOCUMENTO_MODALIDADServiceImpl documento_modalidadService;
    @GetMapping("/list")
    public ResponseEntity<Response> getDOCUMENTO_MODALIDAD() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_MODALIDAD",documento_modalidadService.list(30)))
                        .message("DOCUMENTO_MODALIDAD retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<DOCUMENTO_MODALIDAD> getSimpleDOCUMENTO_MODALIDAD()  {
        return documento_modalidadService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveDOCUMENTO_MODALIDAD(@RequestBody @Valid DOCUMENTO_MODALIDAD documento_modalidad) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_MODALIDAD",documento_modalidadService.create(documento_modalidad)))
                        .message("DOCUMENTO_MODALIDAD created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getDOCUMENTO_MODALIDAD(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_MODALIDAD",documento_modalidadService.get(id)))
                        .message("DOCUMENTO_MODALIDAD retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteDOCUMENTO_MODALIDAD(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",documento_modalidadService.delete(id)))
                        .message("DOCUMENTO_MODALIDAD deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

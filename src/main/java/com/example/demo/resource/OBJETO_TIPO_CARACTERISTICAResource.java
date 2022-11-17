package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.OBJETO_TIPO_CARACTERISTICA;
import com.example.demo.service.implementation.OBJETO_TIPO_CARACTERISTICAServiceImpl;
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
@RequestMapping("/objeto_tipo_caracteristica")
@RequiredArgsConstructor
public class OBJETO_TIPO_CARACTERISTICAResource {
    private final OBJETO_TIPO_CARACTERISTICAServiceImpl objeto_tipo_caracteristicaService;
    @GetMapping("/list")
    public ResponseEntity<Response> getOBJETO_TIPO_CARACTERISTICA() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("OBJETO_TIPO_CARACTERISTICA",objeto_tipo_caracteristicaService.list(30)))
                        .message("OBJETO_TIPO_CARACTERISTICA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<OBJETO_TIPO_CARACTERISTICA> getSimpleOBJETO_TIPO_CARACTERISTICA()  {
        return objeto_tipo_caracteristicaService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveOBJETO_TIPO_CARACTERISTICA(@RequestBody @Valid OBJETO_TIPO_CARACTERISTICA objeto_tipo_caracteristica) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("OBJETO_TIPO_CARACTERISTICA",objeto_tipo_caracteristicaService.create(objeto_tipo_caracteristica)))
                        .message("OBJETO_TIPO_CARACTERISTICA created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getOBJETO_TIPO_CARACTERISTICA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("OBJETO_TIPO_CARACTERISTICA",objeto_tipo_caracteristicaService.get(id)))
                        .message("OBJETO_TIPO_CARACTERISTICA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteOBJETO_TIPO_CARACTERISTICA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",objeto_tipo_caracteristicaService.delete(id)))
                        .message("OBJETO_TIPO_CARACTERISTICA deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
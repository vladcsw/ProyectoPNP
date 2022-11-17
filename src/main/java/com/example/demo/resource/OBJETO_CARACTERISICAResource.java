package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.OBJETO_CARACTERISICA;
import com.example.demo.service.implementation.OBJETO_CARACTERISICAServiceImpl;
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
@RequestMapping("/objeto_caracterisica")
@RequiredArgsConstructor
public class OBJETO_CARACTERISICAResource {
    private final OBJETO_CARACTERISICAServiceImpl objeto_caracterisicaService;
    @GetMapping("/list")
    public ResponseEntity<Response> getOBJETO_CARACTERISICA() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("OBJETO_CARACTERISICA",objeto_caracterisicaService.list(30)))
                        .message("OBJETO_CARACTERISICA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<OBJETO_CARACTERISICA> getSimpleOBJETO_CARACTERISICA()  {
        return objeto_caracterisicaService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveOBJETO_CARACTERISICA(@RequestBody @Valid OBJETO_CARACTERISICA objeto_caracterisica) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("OBJETO_CARACTERISICA",objeto_caracterisicaService.create(objeto_caracterisica)))
                        .message("OBJETO_CARACTERISICA created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getOBJETO_CARACTERISICA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("OBJETO_CARACTERISICA",objeto_caracterisicaService.get(id)))
                        .message("OBJETO_CARACTERISICA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteOBJETO_CARACTERISICA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",objeto_caracterisicaService.delete(id)))
                        .message("OBJETO_CARACTERISICA deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
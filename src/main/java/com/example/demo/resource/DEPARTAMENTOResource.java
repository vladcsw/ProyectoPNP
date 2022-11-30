package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.DEPARTAMENTO;
import com.example.demo.service.implementation.DEPARTAMENTOServiceImpl;
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
@RequestMapping("/departamento")
@RequiredArgsConstructor
public class DEPARTAMENTOResource {
    private final DEPARTAMENTOServiceImpl departamentoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getDEPARTAMENTO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DEPARTAMENTO",departamentoService.list(30)))
                        .message("DEPARTAMENTO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<DEPARTAMENTO> getSimpleDEPARTAMENTO()  {
        return departamentoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveDEPARTAMENTO(@RequestBody @Valid DEPARTAMENTO departamento) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DEPARTAMENTO",departamentoService.create(departamento)))
                        .message("DEPARTAMENTO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getDEPARTAMENTO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DEPARTAMENTO",departamentoService.get(id)))
                        .message("DEPARTAMENTO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteDEPARTAMENTO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",departamentoService.delete(id)))
                        .message("DEPARTAMENTO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

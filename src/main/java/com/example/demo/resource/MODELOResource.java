package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.MODELO;
import com.example.demo.service.implementation.MODELOServiceImpl;
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
@RequestMapping("/modelo")
@RequiredArgsConstructor
public class MODELOResource {
    private final MODELOServiceImpl modeloService;
    @GetMapping("/list")
    public ResponseEntity<Response> getMODELO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("MODELO",modeloService.list(30)))
                        .message("MODELO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<MODELO> getSimpleMODELO()  {
        return modeloService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveMODELO(@RequestBody @Valid MODELO modelo) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("MODELO",modeloService.create(modelo)))
                        .message("MODELO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getMODELO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("MODELO",modeloService.get(id)))
                        .message("MODELO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteMODELO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",modeloService.delete(id)))
                        .message("MODELO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
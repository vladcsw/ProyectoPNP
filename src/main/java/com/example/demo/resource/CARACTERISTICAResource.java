package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.CARACTERISTICA;
import com.example.demo.service.implementation.CARACTERISTICAServiceImpl;
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
@RequestMapping("/caracteristica")
@RequiredArgsConstructor
public class CARACTERISTICAResource {
    private final CARACTERISTICAServiceImpl caracteristicaService;
    @GetMapping("/list")
    public ResponseEntity<Response> getCARACTERISTICA() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("CARACTERISTICA",caracteristicaService.list(30)))
                        .message("CARACTERISTICA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<CARACTERISTICA> getSimpleCARACTERISTICA()  {
        return caracteristicaService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveCARACTERISTICA(@RequestBody @Valid CARACTERISTICA caracteristica) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("CARACTERISTICA",caracteristicaService.create(caracteristica)))
                        .message("CARACTERISTICA created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getCARACTERISTICA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("CARACTERISTICA",caracteristicaService.get(id)))
                        .message("CARACTERISTICA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteCARACTERISTICA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",caracteristicaService.delete(id)))
                        .message("CARACTERISTICA deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
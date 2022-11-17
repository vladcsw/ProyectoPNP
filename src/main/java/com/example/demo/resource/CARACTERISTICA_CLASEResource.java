package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.CARACTERISTICA_CLASE;
import com.example.demo.service.implementation.CARACTERISTICA_CLASEServiceImpl;
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
@RequestMapping("/caracteristica_clase")
@RequiredArgsConstructor
public class CARACTERISTICA_CLASEResource {
    private final CARACTERISTICA_CLASEServiceImpl caracteristica_claseService;
    @GetMapping("/list")
    public ResponseEntity<Response> getCARACTERISTICA_CLASE() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("CARACTERISTICA_CLASE",caracteristica_claseService.list(30)))
                        .message("CARACTERISTICA_CLASE retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<CARACTERISTICA_CLASE> getSimpleCARACTERISTICA_CLASE()  {
        return caracteristica_claseService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveCARACTERISTICA_CLASE(@RequestBody @Valid CARACTERISTICA_CLASE caracteristica_clase) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("CARACTERISTICA_CLASE",caracteristica_claseService.create(caracteristica_clase)))
                        .message("CARACTERISTICA_CLASE created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getCARACTERISTICA_CLASE(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("CARACTERISTICA_CLASE",caracteristica_claseService.get(id)))
                        .message("CARACTERISTICA_CLASE retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteCARACTERISTICA_CLASE(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",caracteristica_claseService.delete(id)))
                        .message("CARACTERISTICA_CLASE deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
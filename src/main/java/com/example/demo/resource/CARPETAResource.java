package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.CARPETA;
import com.example.demo.service.implementation.CARPETAServiceImpl;
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
@RequestMapping("/carpeta")
@RequiredArgsConstructor
public class CARPETAResource {
    private final CARPETAServiceImpl carpetaService;
    @GetMapping("/list")
    public ResponseEntity<Response> getCARPETA() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("CARPETA",carpetaService.list(30)))
                        .message("CARPETA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<CARPETA> getSimpleCARPETA()  {
        return carpetaService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveCARPETA(@RequestBody @Valid CARPETA carpeta) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("CARPETA",carpetaService.create(carpeta)))
                        .message("CARPETA created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getCARPETA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("CARPETA",carpetaService.get(id)))
                        .message("CARPETA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteCARPETA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",carpetaService.delete(id)))
                        .message("CARPETA deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
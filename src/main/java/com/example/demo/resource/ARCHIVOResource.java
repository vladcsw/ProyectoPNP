package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.ARCHIVO;
import com.example.demo.service.implementation.ARCHIVOServiceImpl;
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
@RequestMapping("/archivo")
@RequiredArgsConstructor
public class ARCHIVOResource {
    private final ARCHIVOServiceImpl archivoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getARCHIVO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("ARCHIVO",archivoService.list(30)))
                        .message("ARCHIVO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<ARCHIVO> getSimpleARCHIVO()  {
        return archivoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveARCHIVO(@RequestBody @Valid ARCHIVO archivo) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("ARCHIVO",archivoService.create(archivo)))
                        .message("ARCHIVO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getARCHIVO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("ARCHIVO",archivoService.get(id)))
                        .message("ARCHIVO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteARCHIVO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",archivoService.delete(id)))
                        .message("ARCHIVO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }


}

package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.CARPETA_CLASIFICACION;
import com.example.demo.service.implementation.CARPETA_CLASIFICACIONServiceImpl;
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
@RequestMapping("/carpeta_clasificacion")
@RequiredArgsConstructor
public class CARPETA_CLASIFICACIONResource {
    private final CARPETA_CLASIFICACIONServiceImpl carpeta_clasificacionService;
    @GetMapping("/list")
    public ResponseEntity<Response> getCARPETA_CLASIFICACION() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("CARPETA_CLASIFICACION",carpeta_clasificacionService.list(30)))
                        .message("CARPETA_CLASIFICACION retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<CARPETA_CLASIFICACION> getSimpleCARPETA_CLASIFICACION()  {
        return carpeta_clasificacionService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveCARPETA_CLASIFICACION(@RequestBody @Valid CARPETA_CLASIFICACION carpeta_clasificacion) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("CARPETA_CLASIFICACION",carpeta_clasificacionService.create(carpeta_clasificacion)))
                        .message("CARPETA_CLASIFICACION created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getCARPETA_CLASIFICACION(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("CARPETA_CLASIFICACION",carpeta_clasificacionService.get(id)))
                        .message("CARPETA_CLASIFICACION retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteCARPETA_CLASIFICACION(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",carpeta_clasificacionService.delete(id)))
                        .message("CARPETA_CLASIFICACION deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
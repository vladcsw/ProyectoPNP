package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.CARPETA_TIPO;
import com.example.demo.service.implementation.CARPETA_TIPOServiceImpl;
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
@RequestMapping("/carpeta_tipo")
@RequiredArgsConstructor
public class CARPETA_TIPOResource {
    private final CARPETA_TIPOServiceImpl carpeta_tipoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getCARPETA_TIPO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("CARPETA_TIPO",carpeta_tipoService.list(30)))
                        .message("CARPETA_TIPO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<CARPETA_TIPO> getSimpleCARPETA_TIPO()  {
        return carpeta_tipoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveCARPETA_TIPO(@RequestBody @Valid CARPETA_TIPO carpeta_tipo) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("CARPETA_TIPO",carpeta_tipoService.create(carpeta_tipo)))
                        .message("CARPETA_TIPO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getCARPETA_TIPO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("CARPETA_TIPO",carpeta_tipoService.get(id)))
                        .message("CARPETA_TIPO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteCARPETA_TIPO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",carpeta_tipoService.delete(id)))
                        .message("CARPETA_TIPO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
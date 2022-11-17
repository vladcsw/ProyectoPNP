package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.CARPETA_ORIGEN;
import com.example.demo.service.implementation.CARPETA_ORIGENServiceImpl;
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
@RequestMapping("/carpeta_origen")
@RequiredArgsConstructor
public class CARPETA_ORIGENResource {
    private final CARPETA_ORIGENServiceImpl carpeta_origenService;
    @GetMapping("/list")
    public ResponseEntity<Response> getCARPETA_ORIGEN() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("CARPETA_ORIGEN",carpeta_origenService.list(30)))
                        .message("CARPETA_ORIGEN retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<CARPETA_ORIGEN> getSimpleCARPETA_ORIGEN()  {
        return carpeta_origenService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveCARPETA_ORIGEN(@RequestBody @Valid CARPETA_ORIGEN carpeta_origen) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("CARPETA_ORIGEN",carpeta_origenService.create(carpeta_origen)))
                        .message("CARPETA_ORIGEN created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getCARPETA_ORIGEN(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("CARPETA_ORIGEN",carpeta_origenService.get(id)))
                        .message("CARPETA_ORIGEN retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteCARPETA_ORIGEN(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",carpeta_origenService.delete(id)))
                        .message("CARPETA_ORIGEN deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
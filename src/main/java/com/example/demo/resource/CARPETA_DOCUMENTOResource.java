package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.CARPETA_DOCUMENTO;
import com.example.demo.service.implementation.CARPETA_DOCUMENTOServiceImpl;
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
@RequestMapping("/carpeta_documento")
@RequiredArgsConstructor
public class CARPETA_DOCUMENTOResource {
    private final CARPETA_DOCUMENTOServiceImpl carpeta_documentoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getCARPETA_DOCUMENTO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("CARPETA_DOCUMENTO",carpeta_documentoService.list(30)))
                        .message("CARPETA_DOCUMENTO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<CARPETA_DOCUMENTO> getSimpleCARPETA_DOCUMENTO()  {
        return carpeta_documentoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveCARPETA_DOCUMENTO(@RequestBody @Valid CARPETA_DOCUMENTO carpeta_documento) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("CARPETA_DOCUMENTO",carpeta_documentoService.create(carpeta_documento)))
                        .message("CARPETA_DOCUMENTO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getCARPETA_DOCUMENTO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("CARPETA_DOCUMENTO",carpeta_documentoService.get(id)))
                        .message("CARPETA_DOCUMENTO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteCARPETA_DOCUMENTO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",carpeta_documentoService.delete(id)))
                        .message("CARPETA_DOCUMENTO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
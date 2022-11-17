package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.EQUIPO_CARPETA;
import com.example.demo.service.implementation.EQUIPO_CARPETAServiceImpl;
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
@RequestMapping("/equipo_carpeta")
@RequiredArgsConstructor
public class EQUIPO_CARPETAResource {
    private final EQUIPO_CARPETAServiceImpl equipo_carpetaService;
    @GetMapping("/list")
    public ResponseEntity<Response> getEQUIPO_CARPETA() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("EQUIPO_CARPETA",equipo_carpetaService.list(30)))
                        .message("EQUIPO_CARPETA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<EQUIPO_CARPETA> getSimpleEQUIPO_CARPETA()  {
        return equipo_carpetaService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveEQUIPO_CARPETA(@RequestBody @Valid EQUIPO_CARPETA equipo_carpeta) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("EQUIPO_CARPETA",equipo_carpetaService.create(equipo_carpeta)))
                        .message("EQUIPO_CARPETA created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getEQUIPO_CARPETA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("EQUIPO_CARPETA",equipo_carpetaService.get(id)))
                        .message("EQUIPO_CARPETA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteEQUIPO_CARPETA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",equipo_carpetaService.delete(id)))
                        .message("EQUIPO_CARPETA deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
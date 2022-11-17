package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.EQUIPO;
import com.example.demo.service.implementation.EQUIPOServiceImpl;
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
@RequestMapping("/equipo")
@RequiredArgsConstructor
public class EQUIPOResource {
    private final EQUIPOServiceImpl equipoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getEQUIPO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("EQUIPO",equipoService.list(30)))
                        .message("EQUIPO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<EQUIPO> getSimpleEQUIPO()  {
        return equipoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveEQUIPO(@RequestBody @Valid EQUIPO equipo) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("EQUIPO",equipoService.create(equipo)))
                        .message("EQUIPO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getEQUIPO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("EQUIPO",equipoService.get(id)))
                        .message("EQUIPO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteEQUIPO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",equipoService.delete(id)))
                        .message("EQUIPO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
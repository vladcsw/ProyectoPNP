package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.CENTRO_POBLADO;
import com.example.demo.service.implementation.CENTRO_POBLADOServiceImpl;
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
@RequestMapping("/centro_poblado")
@RequiredArgsConstructor
public class CENTRO_POBLADOResource {
    private final CENTRO_POBLADOServiceImpl centro_pobladoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getCENTRO_POBLADO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("CENTRO_POBLADO",centro_pobladoService.list(30)))
                        .message("CENTRO_POBLADO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<CENTRO_POBLADO> getSimpleCENTRO_POBLADO()  {
        return centro_pobladoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveCENTRO_POBLADO(@RequestBody @Valid CENTRO_POBLADO centro_poblado) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("CENTRO_POBLADO",centro_pobladoService.create(centro_poblado)))
                        .message("CENTRO_POBLADO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getCENTRO_POBLADO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("CENTRO_POBLADO",centro_pobladoService.get(id)))
                        .message("CENTRO_POBLADO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteCENTRO_POBLADO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",centro_pobladoService.delete(id)))
                        .message("CENTRO_POBLADO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

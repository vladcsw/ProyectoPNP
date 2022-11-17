package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.PERSONA_OBJETO;
import com.example.demo.service.implementation.PERSONA_OBJETOServiceImpl;
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
@RequestMapping("/persona_objeto")
@RequiredArgsConstructor
public class PERSONA_OBJETOResource {
    private final PERSONA_OBJETOServiceImpl persona_objetoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getPERSONA_OBJETO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("PERSONA_OBJETO",persona_objetoService.list(30)))
                        .message("PERSONA_OBJETO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<PERSONA_OBJETO> getSimplePERSONA_OBJETO()  {
        return persona_objetoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> savePERSONA_OBJETO(@RequestBody @Valid PERSONA_OBJETO persona_objeto) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("PERSONA_OBJETO",persona_objetoService.create(persona_objeto)))
                        .message("PERSONA_OBJETO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getPERSONA_OBJETO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("PERSONA_OBJETO",persona_objetoService.get(id)))
                        .message("PERSONA_OBJETO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deletePERSONA_OBJETO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",persona_objetoService.delete(id)))
                        .message("PERSONA_OBJETO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
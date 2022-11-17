package com.example.demo.resource;

import com.example.demo.model.PERSONAL_PNP;
import com.example.demo.model.Response;
import com.example.demo.model.PERSONA;
import com.example.demo.service.implementation.PERSONAServiceImpl;
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
@RequestMapping("/persona")
@RequiredArgsConstructor
public class PERSONAResource {
    private final PERSONAServiceImpl personaService;
    @GetMapping("/list")
    public ResponseEntity<Response> getPERSONAs() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("personas",personaService.list(30)))
                        .message("PERSONAs retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<PERSONA> getRELACION_PER_EMPRESAss()  {
        return personaService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> savePERSONA(@RequestBody @Valid PERSONA persona) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("persona",personaService.create(persona)))
                        .message("PERSONA created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getPERSONA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("persona",personaService.get(id)))
                        .message("PERSONA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deletePERSONA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",personaService.delete(id)))
                        .message("PERSONA deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }


}

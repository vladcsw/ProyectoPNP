package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.PERSONA_DOMICILIO;
import com.example.demo.service.implementation.PERSONA_DOMICILIOServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/persona_domicilio")
@RequiredArgsConstructor
public class PERSONA_DOMICILIOResource {
    private final PERSONA_DOMICILIOServiceImpl persona_domicilioService;
    @GetMapping("/list")
    public ResponseEntity<Response> getPERSONA_DOMICILIOs() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("persona_domicilios",persona_domicilioService.list(30)))
                        .message("PERSONA_DOMICILIOs retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> savePERSONA_DOMICILIO(@RequestBody @Valid PERSONA_DOMICILIO persona_domicilio) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("persona_domicilio",persona_domicilioService.create(persona_domicilio)))
                        .message("PERSONA_DOMICILIO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getPERSONA_DOMICILIO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("persona_domicilio",persona_domicilioService.get(id)))
                        .message("PERSONA_DOMICILIO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deletePERSONA_DOMICILIO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",persona_domicilioService.delete(id)))
                        .message("PERSONA_DOMICILIO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }


}

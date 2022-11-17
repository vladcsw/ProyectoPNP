package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.EMPRESA_PERSONA;
import com.example.demo.service.implementation.EMPRESA_PERSONAServiceImpl;
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
@RequestMapping("/empresa_persona")
@RequiredArgsConstructor
public class EMPRESA_PERSONAResource {
    private final EMPRESA_PERSONAServiceImpl empresa_personaService;
    @GetMapping("/list")
    public ResponseEntity<Response> getEMPRESA_PERSONAs() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("empresa_personas",empresa_personaService.list(30)))
                        .message("EMPRESA_PERSONAs retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveEMPRESA_PERSONA(@RequestBody @Valid EMPRESA_PERSONA empresa_persona) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("empresa_persona",empresa_personaService.create(empresa_persona)))
                        .message("EMPRESA_PERSONA created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getEMPRESA_PERSONA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("empresa_persona",empresa_personaService.get(id)))
                        .message("EMPRESA_PERSONA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteEMPRESA_PERSONA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",empresa_personaService.delete(id)))
                        .message("EMPRESA_PERSONA deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }


}

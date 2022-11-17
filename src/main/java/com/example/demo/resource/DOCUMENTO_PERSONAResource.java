package com.example.demo.resource;

import com.example.demo.model.DOCUMENTO_EMPRESA;
import com.example.demo.model.Response;
import com.example.demo.model.DOCUMENTO_PERSONA;
import com.example.demo.service.implementation.DOCUMENTO_PERSONAServiceImpl;
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
@RequestMapping("/documento_persona")
@RequiredArgsConstructor
public class DOCUMENTO_PERSONAResource {
    private final DOCUMENTO_PERSONAServiceImpl documento_personaService;
    @GetMapping("/list")
    public ResponseEntity<Response> getDOCUMENTO_PERSONAs() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("documento_personas",documento_personaService.list(30)))
                        .message("DOCUMENTO_PERSONAs retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<DOCUMENTO_PERSONA> getRELACION_PER_EMPRESAss()  {
        return documento_personaService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveDOCUMENTO_PERSONA(@RequestBody @Valid DOCUMENTO_PERSONA documento_persona) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("documento_persona",documento_personaService.create(documento_persona)))
                        .message("DOCUMENTO_PERSONA created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getDOCUMENTO_PERSONA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("documento_persona",documento_personaService.get(id)))
                        .message("DOCUMENTO_PERSONA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteDOCUMENTO_PERSONA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",documento_personaService.delete(id)))
                        .message("DOCUMENTO_PERSONA deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }


}

package com.example.demo.resource;

import com.example.demo.model.DOCUMENTO;
import com.example.demo.model.Response;
import com.example.demo.model.DOMICILIO;
import com.example.demo.service.implementation.DOMICILIOServiceImpl;
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
@RequestMapping("/domicilio")
@RequiredArgsConstructor
public class DOMICILIOResource {
    private final DOMICILIOServiceImpl domicilioService;
    @GetMapping("/list")
    public ResponseEntity<Response> getDOMICILIOs() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("domicilios",domicilioService.list(30)))
                        .message("DOMICILIOs retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<DOMICILIO> getRELACION_PER_EMPRESAss()  {
        return domicilioService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveDOMICILIO(@RequestBody @Valid DOMICILIO domicilio) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("domicilio",domicilioService.create(domicilio)))
                        .message("DOMICILIO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getDOMICILIO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("domicilio",domicilioService.get(id)))
                        .message("DOMICILIO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteDOMICILIO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",domicilioService.delete(id)))
                        .message("DOMICILIO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }


}

package com.example.demo.resource;

import com.example.demo.model.RELACION_EMP_DOMICILIO;
import com.example.demo.model.Response;
import com.example.demo.model.RELACION_PER_DOMICILIO;
import com.example.demo.service.implementation.RELACION_PER_DOMICILIOServiceImpl;
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
@RequestMapping("/relacion_per_domicilio")
@RequiredArgsConstructor
public class RELACION_PER_DOMICILIOResource {
    private final RELACION_PER_DOMICILIOServiceImpl relacion_per_domicilioService;
    @GetMapping("/list")
    public ResponseEntity<Response> getRELACION_PER_DOMICILIOs() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("relacion_per_domicilios",relacion_per_domicilioService.list(30)))
                        .message("RELACION_PER_DOMICILIOs retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<RELACION_PER_DOMICILIO> getRELACION_PER_EMPRESAss()  {
        return relacion_per_domicilioService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveRELACION_PER_DOMICILIO(@RequestBody @Valid RELACION_PER_DOMICILIO relacion_per_domicilio) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("relacion_per_domicilio",relacion_per_domicilioService.create(relacion_per_domicilio)))
                        .message("RELACION_PER_DOMICILIO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getRELACION_PER_DOMICILIO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("relacion_per_domicilio",relacion_per_domicilioService.get(id)))
                        .message("RELACION_PER_DOMICILIO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteRELACION_PER_DOMICILIO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",relacion_per_domicilioService.delete(id)))
                        .message("RELACION_PER_DOMICILIO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }


}

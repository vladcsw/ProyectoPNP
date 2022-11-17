package com.example.demo.resource;

import com.example.demo.model.RELACION_PER_EMPRESA;
import com.example.demo.model.Response;
import com.example.demo.model.DOCUMENTO_DETALLE;
import com.example.demo.service.implementation.DOCUMENTO_DETALLEServiceImpl;
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
@RequestMapping("/documento_detalle")
@RequiredArgsConstructor
public class DOCUMENTO_DETALLEResource {
    private final DOCUMENTO_DETALLEServiceImpl DOCUMENTO_DETALLEService;
    @GetMapping("/list")
    public ResponseEntity<Response> getDOCUMENTO_DETALLEs() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_DETALLEs",DOCUMENTO_DETALLEService.list(30)))
                        .message("DOCUMENTO_DETALLEs retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<DOCUMENTO_DETALLE> getRELACION_PER_EMPRESAss()  {
        return DOCUMENTO_DETALLEService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveDOCUMENTO_DETALLE(@RequestBody @Valid DOCUMENTO_DETALLE DOCUMENTO_DETALLE) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_DETALLE",DOCUMENTO_DETALLEService.create(DOCUMENTO_DETALLE)))
                        .message("DOCUMENTO_DETALLE created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getDOCUMENTO_DETALLE(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_DETALLE",DOCUMENTO_DETALLEService.get(id)))
                        .message("DOCUMENTO_DETALLE retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteDOCUMENTO_DETALLE(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",DOCUMENTO_DETALLEService.delete(id)))
                        .message("DOCUMENTO_DETALLE deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.DOCUMENTO_INMUEBLE;
import com.example.demo.service.implementation.DOCUMENTO_INMUEBLEServiceImpl;
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
@RequestMapping("/documento_inmueble")
@RequiredArgsConstructor
public class DOCUMENTO_INMUEBLEResource {
    private final DOCUMENTO_INMUEBLEServiceImpl documento_inmuebleService;
    @GetMapping("/list")
    public ResponseEntity<Response> getDOCUMENTO_INMUEBLE() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_INMUEBLE",documento_inmuebleService.list(30)))
                        .message("DOCUMENTO_INMUEBLE retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<DOCUMENTO_INMUEBLE> getSimpleDOCUMENTO_INMUEBLE()  {
        return documento_inmuebleService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveDOCUMENTO_INMUEBLE(@RequestBody @Valid DOCUMENTO_INMUEBLE documento_inmueble) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_INMUEBLE",documento_inmuebleService.create(documento_inmueble)))
                        .message("DOCUMENTO_INMUEBLE created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getDOCUMENTO_INMUEBLE(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_INMUEBLE",documento_inmuebleService.get(id)))
                        .message("DOCUMENTO_INMUEBLE retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteDOCUMENTO_INMUEBLE(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",documento_inmuebleService.delete(id)))
                        .message("DOCUMENTO_INMUEBLE deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }



}

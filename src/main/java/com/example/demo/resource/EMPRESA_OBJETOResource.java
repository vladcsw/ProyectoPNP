package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.EMPRESA_OBJETO;
import com.example.demo.service.implementation.EMPRESA_OBJETOServiceImpl;
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
@RequestMapping("/empresa_objeto")
@RequiredArgsConstructor
public class EMPRESA_OBJETOResource {
    private final EMPRESA_OBJETOServiceImpl empresa_objetoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getEMPRESA_OBJETO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("EMPRESA_OBJETO",empresa_objetoService.list(30)))
                        .message("EMPRESA_OBJETO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<EMPRESA_OBJETO> getSimpleEMPRESA_OBJETO()  {
        return empresa_objetoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveEMPRESA_OBJETO(@RequestBody @Valid EMPRESA_OBJETO empresa_objeto) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("EMPRESA_OBJETO",empresa_objetoService.create(empresa_objeto)))
                        .message("EMPRESA_OBJETO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getEMPRESA_OBJETO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("EMPRESA_OBJETO",empresa_objetoService.get(id)))
                        .message("EMPRESA_OBJETO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteEMPRESA_OBJETO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",empresa_objetoService.delete(id)))
                        .message("EMPRESA_OBJETO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

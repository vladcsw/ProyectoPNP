package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.RELACION_PER_EMPRESA;
import com.example.demo.service.implementation.RELACION_PER_EMPRESAServiceImpl;
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
@RequestMapping("/relacion_per_empresa")
@RequiredArgsConstructor
public class RELACION_PER_EMPRESAResource {
    private final RELACION_PER_EMPRESAServiceImpl relacion_per_empresaService;
    @GetMapping("/list")
    public ResponseEntity<Response> getRELACION_PER_EMPRESAs() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("relacion_per_empresas",relacion_per_empresaService.list(30)))
                        .message("RELACION_PER_EMPRESAs retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<RELACION_PER_EMPRESA> getRELACION_PER_EMPRESAss()  {
        return relacion_per_empresaService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveRELACION_PER_EMPRESA(@RequestBody @Valid RELACION_PER_EMPRESA relacion_per_empresa) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("relacion_per_empresa",relacion_per_empresaService.create(relacion_per_empresa)))
                        .message("RELACION_PER_EMPRESA created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getRELACION_PER_EMPRESA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("relacion_per_empresa",relacion_per_empresaService.get(id)))
                        .message("RELACION_PER_EMPRESA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteRELACION_PER_EMPRESA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",relacion_per_empresaService.delete(id)))
                        .message("RELACION_PER_EMPRESA deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }


}

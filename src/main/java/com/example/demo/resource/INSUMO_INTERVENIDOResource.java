package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.INSUMO_INTERVENIDO;
import com.example.demo.service.implementation.INSUMO_INTERVENIDOServiceImpl;
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
@RequestMapping("/insumo_intervenido")
@RequiredArgsConstructor
public class INSUMO_INTERVENIDOResource {
    private final INSUMO_INTERVENIDOServiceImpl insumo_intervenidoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getINSUMO_INTERVENIDO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("INSUMO_INTERVENIDO",insumo_intervenidoService.list(30)))
                        .message("INSUMO_INTERVENIDO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<INSUMO_INTERVENIDO> getSimpleINSUMO_INTERVENIDO()  {
        return insumo_intervenidoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveINSUMO_INTERVENIDO(@RequestBody @Valid INSUMO_INTERVENIDO insumo_intervenido) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("INSUMO_INTERVENIDO",insumo_intervenidoService.create(insumo_intervenido)))
                        .message("INSUMO_INTERVENIDO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getINSUMO_INTERVENIDO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("INSUMO_INTERVENIDO",insumo_intervenidoService.get(id)))
                        .message("INSUMO_INTERVENIDO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteINSUMO_INTERVENIDO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",insumo_intervenidoService.delete(id)))
                        .message("INSUMO_INTERVENIDO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

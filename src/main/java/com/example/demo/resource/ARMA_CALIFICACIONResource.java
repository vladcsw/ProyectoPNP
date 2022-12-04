package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.ARMA_CALIFICACION;
import com.example.demo.service.implementation.ARMA_CALIFICACIONServiceImpl;
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
@RequestMapping("/arma_calificacion")
@RequiredArgsConstructor
public class ARMA_CALIFICACIONResource {
    private final ARMA_CALIFICACIONServiceImpl arma_calificacionService;
    @GetMapping("/list")
    public ResponseEntity<Response> getARMA_CALIFICACION() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("ARMA_CALIFICACION",arma_calificacionService.list(30)))
                        .message("ARMA_CALIFICACION retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<ARMA_CALIFICACION> getSimpleARMA_CALIFICACION()  {
        return arma_calificacionService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveARMA_CALIFICACION(@RequestBody @Valid ARMA_CALIFICACION arma_calificacion) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("ARMA_CALIFICACION",arma_calificacionService.create(arma_calificacion)))
                        .message("ARMA_CALIFICACION created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getARMA_CALIFICACION(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("ARMA_CALIFICACION",arma_calificacionService.get(id)))
                        .message("ARMA_CALIFICACION retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteARMA_CALIFICACION(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",arma_calificacionService.delete(id)))
                        .message("ARMA_CALIFICACION deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

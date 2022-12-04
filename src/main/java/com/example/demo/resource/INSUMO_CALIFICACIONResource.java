package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.INSUMO_CALIFICACION;
import com.example.demo.service.implementation.INSUMO_CALIFICACIONServiceImpl;
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
@RequestMapping("/insumo_calificacion")
@RequiredArgsConstructor
public class INSUMO_CALIFICACIONResource {
    private final INSUMO_CALIFICACIONServiceImpl insumo_calificacionService;
    @GetMapping("/list")
    public ResponseEntity<Response> getINSUMO_CALIFICACION() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("INSUMO_CALIFICACION",insumo_calificacionService.list(30)))
                        .message("INSUMO_CALIFICACION retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<INSUMO_CALIFICACION> getSimpleINSUMO_CALIFICACION()  {
        return insumo_calificacionService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveINSUMO_CALIFICACION(@RequestBody @Valid INSUMO_CALIFICACION insumo_calificacion) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("INSUMO_CALIFICACION",insumo_calificacionService.create(insumo_calificacion)))
                        .message("INSUMO_CALIFICACION created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getINSUMO_CALIFICACION(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("INSUMO_CALIFICACION",insumo_calificacionService.get(id)))
                        .message("INSUMO_CALIFICACION retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteINSUMO_CALIFICACION(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",insumo_calificacionService.delete(id)))
                        .message("INSUMO_CALIFICACION deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

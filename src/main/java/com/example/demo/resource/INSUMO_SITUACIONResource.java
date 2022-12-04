package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.INSUMO_SITUACION;
import com.example.demo.service.implementation.INSUMO_SITUACIONServiceImpl;
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
@RequestMapping("/insumo_situacion")
@RequiredArgsConstructor
public class INSUMO_SITUACIONResource {
    private final INSUMO_SITUACIONServiceImpl insumo_situacionService;
    @GetMapping("/list")
    public ResponseEntity<Response> getINSUMO_SITUACION() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("INSUMO_SITUACION",insumo_situacionService.list(30)))
                        .message("INSUMO_SITUACION retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<INSUMO_SITUACION> getSimpleINSUMO_SITUACION()  {
        return insumo_situacionService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveINSUMO_SITUACION(@RequestBody @Valid INSUMO_SITUACION insumo_situacion) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("INSUMO_SITUACION",insumo_situacionService.create(insumo_situacion)))
                        .message("INSUMO_SITUACION created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getINSUMO_SITUACION(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("INSUMO_SITUACION",insumo_situacionService.get(id)))
                        .message("INSUMO_SITUACION retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteINSUMO_SITUACION(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",insumo_situacionService.delete(id)))
                        .message("INSUMO_SITUACION deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

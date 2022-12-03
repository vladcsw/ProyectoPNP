package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.DOCUMENTO_VEHICULO;
import com.example.demo.service.implementation.DOCUMENTO_VEHICULOServiceImpl;
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
@RequestMapping("/documento_vehiculo")
@RequiredArgsConstructor
public class DOCUMENTO_VEHICULOResource {
    private final DOCUMENTO_VEHICULOServiceImpl documento_vehiculoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getDOCUMENTO_VEHICULO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_VEHICULO",documento_vehiculoService.list(30)))
                        .message("DOCUMENTO_VEHICULO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<DOCUMENTO_VEHICULO> getSimpleDOCUMENTO_VEHICULO()  {
        return documento_vehiculoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveDOCUMENTO_VEHICULO(@RequestBody @Valid DOCUMENTO_VEHICULO documento_vehiculo) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_VEHICULO",documento_vehiculoService.create(documento_vehiculo)))
                        .message("DOCUMENTO_VEHICULO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getDOCUMENTO_VEHICULO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_VEHICULO",documento_vehiculoService.get(id)))
                        .message("DOCUMENTO_VEHICULO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteDOCUMENTO_VEHICULO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",documento_vehiculoService.delete(id)))
                        .message("DOCUMENTO_VEHICULO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

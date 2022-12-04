package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.VEHICULO;
import com.example.demo.service.implementation.VEHICULOServiceImpl;
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
@RequestMapping("/vehiculo")
@RequiredArgsConstructor
public class VEHICULOResource {
    private final VEHICULOServiceImpl vehiculoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getVEHICULO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("VEHICULO",vehiculoService.list(30)))
                        .message("VEHICULO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<VEHICULO> getSimpleVEHICULO()  {
        return vehiculoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveVEHICULO(@RequestBody @Valid VEHICULO vehiculo) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("VEHICULO",vehiculoService.create(vehiculo)))
                        .message("VEHICULO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getVEHICULO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("VEHICULO",vehiculoService.get(id)))
                        .message("VEHICULO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteVEHICULO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",vehiculoService.delete(id)))
                        .message("VEHICULO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

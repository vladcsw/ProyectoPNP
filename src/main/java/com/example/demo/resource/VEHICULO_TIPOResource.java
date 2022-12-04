package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.VEHICULO_TIPO;
import com.example.demo.service.implementation.VEHICULO_TIPOServiceImpl;
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
@RequestMapping("/vehiculo_tipo")
@RequiredArgsConstructor
public class VEHICULO_TIPOResource {
    private final VEHICULO_TIPOServiceImpl vehiculo_tipoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getVEHICULO_TIPO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("VEHICULO_TIPO",vehiculo_tipoService.list(30)))
                        .message("VEHICULO_TIPO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<VEHICULO_TIPO> getSimpleVEHICULO_TIPO()  {
        return vehiculo_tipoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveVEHICULO_TIPO(@RequestBody @Valid VEHICULO_TIPO vehiculo_tipo) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("VEHICULO_TIPO",vehiculo_tipoService.create(vehiculo_tipo)))
                        .message("VEHICULO_TIPO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getVEHICULO_TIPO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("VEHICULO_TIPO",vehiculo_tipoService.get(id)))
                        .message("VEHICULO_TIPO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteVEHICULO_TIPO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",vehiculo_tipoService.delete(id)))
                        .message("VEHICULO_TIPO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

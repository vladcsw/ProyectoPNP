package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.INMUEBLE_TPO_ZONA;
import com.example.demo.service.implementation.INMUEBLE_TPO_ZONAServiceImpl;
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
@RequestMapping("/inmueble_tpo_zona")
@RequiredArgsConstructor
public class INMUEBLE_TPO_ZONAResource {
    private final INMUEBLE_TPO_ZONAServiceImpl inmueble_tpo_zonaService;
    @GetMapping("/list")
    public ResponseEntity<Response> getINMUEBLE_TPO_ZONA() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("INMUEBLE_TPO_ZONA",inmueble_tpo_zonaService.list(30)))
                        .message("INMUEBLE_TPO_ZONA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<INMUEBLE_TPO_ZONA> getSimpleINMUEBLE_TPO_ZONA()  {
        return inmueble_tpo_zonaService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveINMUEBLE_TPO_ZONA(@RequestBody @Valid INMUEBLE_TPO_ZONA inmueble_tpo_zona) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("INMUEBLE_TPO_ZONA",inmueble_tpo_zonaService.create(inmueble_tpo_zona)))
                        .message("INMUEBLE_TPO_ZONA created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getINMUEBLE_TPO_ZONA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("INMUEBLE_TPO_ZONA",inmueble_tpo_zonaService.get(id)))
                        .message("INMUEBLE_TPO_ZONA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteINMUEBLE_TPO_ZONA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",inmueble_tpo_zonaService.delete(id)))
                        .message("INMUEBLE_TPO_ZONA deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

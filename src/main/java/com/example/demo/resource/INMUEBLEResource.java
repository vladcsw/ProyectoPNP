package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.INMUEBLE;
import com.example.demo.service.implementation.INMUEBLEServiceImpl;
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
@RequestMapping("/inmueble")
@RequiredArgsConstructor
public class INMUEBLEResource {
    private final INMUEBLEServiceImpl inmuebleService;
    @GetMapping("/list")
    public ResponseEntity<Response> getINMUEBLE() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("INMUEBLE",inmuebleService.list(30)))
                        .message("INMUEBLE retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<INMUEBLE> getSimpleINMUEBLE()  {
        return inmuebleService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveINMUEBLE(@RequestBody @Valid INMUEBLE inmueble) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("INMUEBLE",inmuebleService.create(inmueble)))
                        .message("INMUEBLE created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getINMUEBLE(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("INMUEBLE",inmuebleService.get(id)))
                        .message("INMUEBLE retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteINMUEBLE(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",inmuebleService.delete(id)))
                        .message("INMUEBLE deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

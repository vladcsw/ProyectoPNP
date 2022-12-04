package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.ARMA;
import com.example.demo.service.implementation.ARMAServiceImpl;
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
@RequestMapping("/arma")
@RequiredArgsConstructor
public class ARMAResource {
    private final ARMAServiceImpl armaService;
    @GetMapping("/list")
    public ResponseEntity<Response> getARMA() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("ARMA",armaService.list(30)))
                        .message("ARMA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<ARMA> getSimpleARMA()  {
        return armaService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveARMA(@RequestBody @Valid ARMA arma) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("ARMA",armaService.create(arma)))
                        .message("ARMA created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getARMA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("ARMA",armaService.get(id)))
                        .message("ARMA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteARMA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",armaService.delete(id)))
                        .message("ARMA deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

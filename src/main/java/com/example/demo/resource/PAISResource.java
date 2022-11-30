package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.PAIS;
import com.example.demo.service.implementation.PAISServiceImpl;
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
@RequestMapping("/pais")
@RequiredArgsConstructor
public class PAISResource {
    private final PAISServiceImpl paisService;
    @GetMapping("/list")
    public ResponseEntity<Response> getPAIS() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("PAIS",paisService.list(30)))
                        .message("PAIS retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<PAIS> getSimplePAIS()  {
        return paisService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> savePAIS(@RequestBody @Valid PAIS pais) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("PAIS",paisService.create(pais)))
                        .message("PAIS created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getPAIS(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("PAIS",paisService.get(id)))
                        .message("PAIS retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deletePAIS(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",paisService.delete(id)))
                        .message("PAIS deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

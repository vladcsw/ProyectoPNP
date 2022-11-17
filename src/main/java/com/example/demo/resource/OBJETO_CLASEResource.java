package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.OBJETO_CLASE;
import com.example.demo.service.implementation.OBJETO_CLASEServiceImpl;
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
@RequestMapping("/objeto_clase")
@RequiredArgsConstructor
public class OBJETO_CLASEResource {
    private final OBJETO_CLASEServiceImpl objeto_claseService;
    @GetMapping("/list")
    public ResponseEntity<Response> getOBJETO_CLASE() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("OBJETO_CLASE",objeto_claseService.list(30)))
                        .message("OBJETO_CLASE retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<OBJETO_CLASE> getSimpleOBJETO_CLASE()  {
        return objeto_claseService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveOBJETO_CLASE(@RequestBody @Valid OBJETO_CLASE objeto_clase) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("OBJETO_CLASE",objeto_claseService.create(objeto_clase)))
                        .message("OBJETO_CLASE created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getOBJETO_CLASE(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("OBJETO_CLASE",objeto_claseService.get(id)))
                        .message("OBJETO_CLASE retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteOBJETO_CLASE(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",objeto_claseService.delete(id)))
                        .message("OBJETO_CLASE deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
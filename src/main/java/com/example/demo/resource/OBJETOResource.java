package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.OBJETO;
import com.example.demo.service.implementation.OBJETOServiceImpl;
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
@RequestMapping("/objeto")
@RequiredArgsConstructor
public class OBJETOResource {
    private final OBJETOServiceImpl objetoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getOBJETO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("OBJETO",objetoService.list(30)))
                        .message("OBJETO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<OBJETO> getSimpleOBJETO()  {
        return objetoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveOBJETO(@RequestBody @Valid OBJETO objeto) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("OBJETO",objetoService.create(objeto)))
                        .message("OBJETO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getOBJETO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("OBJETO",objetoService.get(id)))
                        .message("OBJETO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteOBJETO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",objetoService.delete(id)))
                        .message("OBJETO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
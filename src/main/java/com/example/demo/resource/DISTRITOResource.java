package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.DISTRITO;
import com.example.demo.service.implementation.DISTRITOServiceImpl;
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
@RequestMapping("/distrito")
@RequiredArgsConstructor
public class DISTRITOResource {
    private final DISTRITOServiceImpl distritoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getDISTRITO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DISTRITO",distritoService.list(30)))
                        .message("DISTRITO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<DISTRITO> getSimpleDISTRITO()  {
        return distritoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveDISTRITO(@RequestBody @Valid DISTRITO distrito) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DISTRITO",distritoService.create(distrito)))
                        .message("DISTRITO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getDISTRITO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DISTRITO",distritoService.get(id)))
                        .message("DISTRITO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteDISTRITO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",distritoService.delete(id)))
                        .message("DISTRITO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

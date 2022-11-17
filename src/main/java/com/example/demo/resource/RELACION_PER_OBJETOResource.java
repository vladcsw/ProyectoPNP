package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.RELACION_PER_OBJETO;
import com.example.demo.service.implementation.RELACION_PER_OBJETOServiceImpl;
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
@RequestMapping("/relacion_per_objeto")
@RequiredArgsConstructor
public class RELACION_PER_OBJETOResource {
    private final RELACION_PER_OBJETOServiceImpl relacion_per_objetoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getRELACION_PER_OBJETO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("RELACION_PER_OBJETO",relacion_per_objetoService.list(30)))
                        .message("RELACION_PER_OBJETO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<RELACION_PER_OBJETO> getSimpleRELACION_PER_OBJETO()  {
        return relacion_per_objetoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveRELACION_PER_OBJETO(@RequestBody @Valid RELACION_PER_OBJETO relacion_per_objeto) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("RELACION_PER_OBJETO",relacion_per_objetoService.create(relacion_per_objeto)))
                        .message("RELACION_PER_OBJETO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getRELACION_PER_OBJETO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("RELACION_PER_OBJETO",relacion_per_objetoService.get(id)))
                        .message("RELACION_PER_OBJETO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteRELACION_PER_OBJETO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",relacion_per_objetoService.delete(id)))
                        .message("RELACION_PER_OBJETO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
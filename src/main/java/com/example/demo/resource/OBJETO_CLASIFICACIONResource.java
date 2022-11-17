package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.OBJETO_CLASIFICACION;
import com.example.demo.service.implementation.OBJETO_CLASIFICACIONServiceImpl;
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
@RequestMapping("/objeto_clasificacion")
@RequiredArgsConstructor
public class OBJETO_CLASIFICACIONResource {
    private final OBJETO_CLASIFICACIONServiceImpl objeto_clasificacionService;
    @GetMapping("/list")
    public ResponseEntity<Response> getOBJETO_CLASIFICACION() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("OBJETO_CLASIFICACION",objeto_clasificacionService.list(30)))
                        .message("OBJETO_CLASIFICACION retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<OBJETO_CLASIFICACION> getSimpleOBJETO_CLASIFICACION()  {
        return objeto_clasificacionService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveOBJETO_CLASIFICACION(@RequestBody @Valid OBJETO_CLASIFICACION objeto_clasificacion) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("OBJETO_CLASIFICACION",objeto_clasificacionService.create(objeto_clasificacion)))
                        .message("OBJETO_CLASIFICACION created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getOBJETO_CLASIFICACION(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("OBJETO_CLASIFICACION",objeto_clasificacionService.get(id)))
                        .message("OBJETO_CLASIFICACION retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteOBJETO_CLASIFICACION(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",objeto_clasificacionService.delete(id)))
                        .message("OBJETO_CLASIFICACION deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
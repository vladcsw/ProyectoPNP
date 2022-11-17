package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.OBJETO_TIPO;
import com.example.demo.service.implementation.OBJETO_TIPOServiceImpl;
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
@RequestMapping("/objeto_tipo")
@RequiredArgsConstructor
public class OBJETO_TIPOResource {
    private final OBJETO_TIPOServiceImpl objeto_tipoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getOBJETO_TIPO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("OBJETO_TIPO",objeto_tipoService.list(30)))
                        .message("OBJETO_TIPO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<OBJETO_TIPO> getSimpleOBJETO_TIPO()  {
        return objeto_tipoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveOBJETO_TIPO(@RequestBody @Valid OBJETO_TIPO objeto_tipo) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("OBJETO_TIPO",objeto_tipoService.create(objeto_tipo)))
                        .message("OBJETO_TIPO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getOBJETO_TIPO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("OBJETO_TIPO",objeto_tipoService.get(id)))
                        .message("OBJETO_TIPO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteOBJETO_TIPO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",objeto_tipoService.delete(id)))
                        .message("OBJETO_TIPO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
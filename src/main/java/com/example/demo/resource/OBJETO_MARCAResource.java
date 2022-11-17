package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.OBJETO_MARCA;
import com.example.demo.service.implementation.OBJETO_MARCAServiceImpl;
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
@RequestMapping("/objeto_marca")
@RequiredArgsConstructor
public class OBJETO_MARCAResource {
    private final OBJETO_MARCAServiceImpl objeto_marcaService;
    @GetMapping("/list")
    public ResponseEntity<Response> getOBJETO_MARCA() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("OBJETO_MARCA",objeto_marcaService.list(30)))
                        .message("OBJETO_MARCA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<OBJETO_MARCA> getSimpleOBJETO_MARCA()  {
        return objeto_marcaService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveOBJETO_MARCA(@RequestBody @Valid OBJETO_MARCA objeto_marca) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("OBJETO_MARCA",objeto_marcaService.create(objeto_marca)))
                        .message("OBJETO_MARCA created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getOBJETO_MARCA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("OBJETO_MARCA",objeto_marcaService.get(id)))
                        .message("OBJETO_MARCA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteOBJETO_MARCA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",objeto_marcaService.delete(id)))
                        .message("OBJETO_MARCA deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
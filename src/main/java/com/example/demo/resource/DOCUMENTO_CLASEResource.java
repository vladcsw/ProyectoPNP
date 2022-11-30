package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.DOCUMENTO_CLASE;
import com.example.demo.service.implementation.DOCUMENTO_CLASEServiceImpl;
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
@RequestMapping("/documento_clase")
@RequiredArgsConstructor
public class DOCUMENTO_CLASEResource {
    private final DOCUMENTO_CLASEServiceImpl documento_claseService;
    @GetMapping("/list")
    public ResponseEntity<Response> getDOCUMENTO_CLASE() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_CLASE",documento_claseService.list(30)))
                        .message("DOCUMENTO_CLASE retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<DOCUMENTO_CLASE> getSimpleDOCUMENTO_CLASE()  {
        return documento_claseService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveDOCUMENTO_CLASE(@RequestBody @Valid DOCUMENTO_CLASE documento_clase) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_CLASE",documento_claseService.create(documento_clase)))
                        .message("DOCUMENTO_CLASE created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getDOCUMENTO_CLASE(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_CLASE",documento_claseService.get(id)))
                        .message("DOCUMENTO_CLASE retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteDOCUMENTO_CLASE(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",documento_claseService.delete(id)))
                        .message("DOCUMENTO_CLASE deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

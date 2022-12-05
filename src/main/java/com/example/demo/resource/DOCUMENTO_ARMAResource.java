package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.DOCUMENTO_ARMA;
import com.example.demo.service.implementation.DOCUMENTO_ARMAServiceImpl;
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
@RequestMapping("/documento_arma")
@RequiredArgsConstructor
public class DOCUMENTO_ARMAResource {
    private final DOCUMENTO_ARMAServiceImpl documento_armaService;
    @GetMapping("/list")
    public ResponseEntity<Response> getDOCUMENTO_ARMA() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_ARMA",documento_armaService.list(30)))
                        .message("DOCUMENTO_ARMA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<DOCUMENTO_ARMA> getSimpleDOCUMENTO_ARMA()  {
        return documento_armaService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveDOCUMENTO_ARMA(@RequestBody @Valid DOCUMENTO_ARMA documento_arma) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_ARMA",documento_armaService.create(documento_arma)))
                        .message("DOCUMENTO_ARMA created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getDOCUMENTO_ARMA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_ARMA",documento_armaService.get(id)))
                        .message("DOCUMENTO_ARMA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteDOCUMENTO_ARMA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",documento_armaService.delete(id)))
                        .message("DOCUMENTO_ARMA deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

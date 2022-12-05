package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.DOCUMENTO_INSUMO;
import com.example.demo.service.implementation.DOCUMENTO_INSUMOServiceImpl;
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
@RequestMapping("/documento_insumo")
@RequiredArgsConstructor
public class DOCUMENTO_INSUMOResource {
    private final DOCUMENTO_INSUMOServiceImpl documento_insumoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getDOCUMENTO_INSUMO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_INSUMO",documento_insumoService.list(30)))
                        .message("DOCUMENTO_INSUMO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<DOCUMENTO_INSUMO> getSimpleDOCUMENTO_INSUMO()  {
        return documento_insumoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveDOCUMENTO_INSUMO(@RequestBody @Valid DOCUMENTO_INSUMO documento_insumo) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_INSUMO",documento_insumoService.create(documento_insumo)))
                        .message("DOCUMENTO_INSUMO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getDOCUMENTO_INSUMO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_INSUMO",documento_insumoService.get(id)))
                        .message("DOCUMENTO_INSUMO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteDOCUMENTO_INSUMO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",documento_insumoService.delete(id)))
                        .message("DOCUMENTO_INSUMO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

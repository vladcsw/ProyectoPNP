package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.DOCUMENTO_CLASE_TIPO;
import com.example.demo.service.implementation.DOCUMENTO_CLASE_TIPOServiceImpl;
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
@RequestMapping("/documento_clase_tipo")
@RequiredArgsConstructor
public class DOCUMENTO_CLASE_TIPOResource {
    private final DOCUMENTO_CLASE_TIPOServiceImpl documento_clase_tipoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getDOCUMENTO_CLASE_TIPO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_CLASE_TIPO",documento_clase_tipoService.list(30)))
                        .message("DOCUMENTO_CLASE_TIPO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<DOCUMENTO_CLASE_TIPO> getSimpleDOCUMENTO_CLASE_TIPO()  {
        return documento_clase_tipoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveDOCUMENTO_CLASE_TIPO(@RequestBody @Valid DOCUMENTO_CLASE_TIPO documento_clase_tipo) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_CLASE_TIPO",documento_clase_tipoService.create(documento_clase_tipo)))
                        .message("DOCUMENTO_CLASE_TIPO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getDOCUMENTO_CLASE_TIPO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_CLASE_TIPO",documento_clase_tipoService.get(id)))
                        .message("DOCUMENTO_CLASE_TIPO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteDOCUMENTO_CLASE_TIPO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",documento_clase_tipoService.delete(id)))
                        .message("DOCUMENTO_CLASE_TIPO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

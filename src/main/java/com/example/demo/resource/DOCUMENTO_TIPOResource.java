package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.DOCUMENTO_TIPO;
import com.example.demo.service.implementation.DOCUMENTO_TIPOServiceImpl;
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
@RequestMapping("/documento_tipo")
@RequiredArgsConstructor
public class DOCUMENTO_TIPOResource {
    private final DOCUMENTO_TIPOServiceImpl documento_tipoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getDOCUMENTO_TIPO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_TIPO",documento_tipoService.list(30)))
                        .message("DOCUMENTO_TIPO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<DOCUMENTO_TIPO> getSimpleDOCUMENTO_TIPO()  {
        return documento_tipoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveDOCUMENTO_TIPO(@RequestBody @Valid DOCUMENTO_TIPO documento_tipo) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_TIPO",documento_tipoService.create(documento_tipo)))
                        .message("DOCUMENTO_TIPO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getDOCUMENTO_TIPO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_TIPO",documento_tipoService.get(id)))
                        .message("DOCUMENTO_TIPO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteDOCUMENTO_TIPO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",documento_tipoService.delete(id)))
                        .message("DOCUMENTO_TIPO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

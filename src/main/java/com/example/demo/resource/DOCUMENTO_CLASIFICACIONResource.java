package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.DOCUMENTO_CLASIFICACION;
import com.example.demo.service.implementation.DOCUMENTO_CLASIFICACIONServiceImpl;
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
@RequestMapping("/documento_clasificacion")
@RequiredArgsConstructor
public class DOCUMENTO_CLASIFICACIONResource {
    private final DOCUMENTO_CLASIFICACIONServiceImpl documento_clasificacionService;
    @GetMapping("/list")
    public ResponseEntity<Response> getDOCUMENTO_CLASIFICACION() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_CLASIFICACION",documento_clasificacionService.list(30)))
                        .message("DOCUMENTO_CLASIFICACION retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<DOCUMENTO_CLASIFICACION> getSimpleDOCUMENTO_CLASIFICACION()  {
        return documento_clasificacionService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveDOCUMENTO_CLASIFICACION(@RequestBody @Valid DOCUMENTO_CLASIFICACION documento_clasificacion) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_CLASIFICACION",documento_clasificacionService.create(documento_clasificacion)))
                        .message("DOCUMENTO_CLASIFICACION created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getDOCUMENTO_CLASIFICACION(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_CLASIFICACION",documento_clasificacionService.get(id)))
                        .message("DOCUMENTO_CLASIFICACION retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteDOCUMENTO_CLASIFICACION(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",documento_clasificacionService.delete(id)))
                        .message("DOCUMENTO_CLASIFICACION deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
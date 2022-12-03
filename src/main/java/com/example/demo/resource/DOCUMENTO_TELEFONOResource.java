package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.DOCUMENTO_TELEFONO;
import com.example.demo.service.implementation.DOCUMENTO_TELEFONOServiceImpl;
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
@RequestMapping("/documento_telefono")
@RequiredArgsConstructor
public class DOCUMENTO_TELEFONOResource {
    private final DOCUMENTO_TELEFONOServiceImpl documento_telefonoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getDOCUMENTO_TELEFONO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_TELEFONO",documento_telefonoService.list(30)))
                        .message("DOCUMENTO_TELEFONO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<DOCUMENTO_TELEFONO> getSimpleDOCUMENTO_TELEFONO()  {
        return documento_telefonoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveDOCUMENTO_TELEFONO(@RequestBody @Valid DOCUMENTO_TELEFONO documento_telefono) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_TELEFONO",documento_telefonoService.create(documento_telefono)))
                        .message("DOCUMENTO_TELEFONO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getDOCUMENTO_TELEFONO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_TELEFONO",documento_telefonoService.get(id)))
                        .message("DOCUMENTO_TELEFONO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteDOCUMENTO_TELEFONO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",documento_telefonoService.delete(id)))
                        .message("DOCUMENTO_TELEFONO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

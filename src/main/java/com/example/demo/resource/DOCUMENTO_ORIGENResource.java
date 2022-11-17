package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.DOCUMENTO_ORIGEN;
import com.example.demo.service.implementation.DOCUMENTO_ORIGENServiceImpl;
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
@RequestMapping("/documento_origen")
@RequiredArgsConstructor
public class DOCUMENTO_ORIGENResource {
    private final DOCUMENTO_ORIGENServiceImpl documento_origenService;
    @GetMapping("/list")
    public ResponseEntity<Response> getDOCUMENTO_ORIGEN() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_ORIGEN",documento_origenService.list(30)))
                        .message("DOCUMENTO_ORIGEN retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<DOCUMENTO_ORIGEN> getSimpleDOCUMENTO_ORIGEN()  {
        return documento_origenService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveDOCUMENTO_ORIGEN(@RequestBody @Valid DOCUMENTO_ORIGEN documento_origen) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_ORIGEN",documento_origenService.create(documento_origen)))
                        .message("DOCUMENTO_ORIGEN created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getDOCUMENTO_ORIGEN(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_ORIGEN",documento_origenService.get(id)))
                        .message("DOCUMENTO_ORIGEN retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteDOCUMENTO_ORIGEN(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",documento_origenService.delete(id)))
                        .message("DOCUMENTO_ORIGEN deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
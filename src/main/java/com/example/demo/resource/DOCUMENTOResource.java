package com.example.demo.resource;

import com.example.demo.model.DOCUMENTO_PERSONA;
import com.example.demo.model.Response;
import com.example.demo.model.DOCUMENTO;
import com.example.demo.service.implementation.DOCUMENTOServiceImpl;
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
@RequestMapping("/documento")
@RequiredArgsConstructor
public class DOCUMENTOResource {
    private final DOCUMENTOServiceImpl documentoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getDOCUMENTOs() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("documentos",documentoService.list(30)))
                        .message("DOCUMENTOs retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<DOCUMENTO> getRELACION_PER_EMPRESAss()  {
        return documentoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveDOCUMENTO(@RequestBody @Valid DOCUMENTO documento) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("documento",documentoService.create(documento)))
                        .message("DOCUMENTO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getDOCUMENTO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("documento",documentoService.get(id)))
                        .message("DOCUMENTO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteDOCUMENTO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",documentoService.delete(id)))
                        .message("DOCUMENTO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }


}

package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.RELACION_DOCUMENTO;
import com.example.demo.service.implementation.RELACION_DOCUMENTOServiceImpl;
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
@RequestMapping("/relacion_documento")
@RequiredArgsConstructor
public class RELACION_DOCUMENTOResource {
    private final RELACION_DOCUMENTOServiceImpl relacion_documentoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getRELACION_DOCUMENTO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("RELACION_DOCUMENTO",relacion_documentoService.list(30)))
                        .message("RELACION_DOCUMENTO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<RELACION_DOCUMENTO> getSimpleRELACION_DOCUMENTO()  {
        return relacion_documentoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveRELACION_DOCUMENTO(@RequestBody @Valid RELACION_DOCUMENTO relacion_documento) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("RELACION_DOCUMENTO",relacion_documentoService.create(relacion_documento)))
                        .message("RELACION_DOCUMENTO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getRELACION_DOCUMENTO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("RELACION_DOCUMENTO",relacion_documentoService.get(id)))
                        .message("RELACION_DOCUMENTO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteRELACION_DOCUMENTO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",relacion_documentoService.delete(id)))
                        .message("RELACION_DOCUMENTO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
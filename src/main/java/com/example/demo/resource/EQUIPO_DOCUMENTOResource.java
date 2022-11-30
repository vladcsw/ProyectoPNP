package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.EQUIPO_DOCUMENTO;
import com.example.demo.service.implementation.EQUIPO_DOCUMENTOServiceImpl;
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
@RequestMapping("/equipo_documento")
@RequiredArgsConstructor
public class EQUIPO_DOCUMENTOResource {
    private final EQUIPO_DOCUMENTOServiceImpl equipo_documentoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getEQUIPO_DOCUMENTO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("EQUIPO_DOCUMENTO",equipo_documentoService.list(30)))
                        .message("EQUIPO_DOCUMENTO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<EQUIPO_DOCUMENTO> getSimpleEQUIPO_DOCUMENTO()  {
        return equipo_documentoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveEQUIPO_DOCUMENTO(@RequestBody @Valid EQUIPO_DOCUMENTO equipo_documento) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("EQUIPO_DOCUMENTO",equipo_documentoService.create(equipo_documento)))
                        .message("EQUIPO_DOCUMENTO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getEQUIPO_DOCUMENTO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("EQUIPO_DOCUMENTO",equipo_documentoService.get(id)))
                        .message("EQUIPO_DOCUMENTO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteEQUIPO_DOCUMENTO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",equipo_documentoService.delete(id)))
                        .message("EQUIPO_DOCUMENTO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

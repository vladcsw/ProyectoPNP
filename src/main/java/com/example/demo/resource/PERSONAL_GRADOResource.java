package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.PERSONAL_GRADO;
import com.example.demo.service.implementation.PERSONAL_GRADOServiceImpl;
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
@RequestMapping("/personal_grado")
@RequiredArgsConstructor
public class PERSONAL_GRADOResource {
    private final PERSONAL_GRADOServiceImpl personal_gradoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getPERSONAL_GRADO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("PERSONAL_GRADO",personal_gradoService.list(30)))
                        .message("PERSONAL_GRADO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<PERSONAL_GRADO> getSimplePERSONAL_GRADO()  {
        return personal_gradoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> savePERSONAL_GRADO(@RequestBody @Valid PERSONAL_GRADO personal_grado) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("PERSONAL_GRADO",personal_gradoService.create(personal_grado)))
                        .message("PERSONAL_GRADO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getPERSONAL_GRADO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("PERSONAL_GRADO",personal_gradoService.get(id)))
                        .message("PERSONAL_GRADO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deletePERSONAL_GRADO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",personal_gradoService.delete(id)))
                        .message("PERSONAL_GRADO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
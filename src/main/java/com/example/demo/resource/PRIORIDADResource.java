package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.PRIORIDAD;
import com.example.demo.service.implementation.PRIORIDADServiceImpl;
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
@RequestMapping("/prioridad")
@RequiredArgsConstructor
public class PRIORIDADResource {
    private final PRIORIDADServiceImpl prioridadService;
    @GetMapping("/list")
    public ResponseEntity<Response> getPRIORIDAD() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("PRIORIDAD",prioridadService.list(30)))
                        .message("PRIORIDAD retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<PRIORIDAD> getSimplePRIORIDAD()  {
        return prioridadService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> savePRIORIDAD(@RequestBody @Valid PRIORIDAD prioridad) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("PRIORIDAD",prioridadService.create(prioridad)))
                        .message("PRIORIDAD created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getPRIORIDAD(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("PRIORIDAD",prioridadService.get(id)))
                        .message("PRIORIDAD retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deletePRIORIDAD(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",prioridadService.delete(id)))
                        .message("PRIORIDAD deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

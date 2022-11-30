package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.NACIONALIDAD;
import com.example.demo.service.implementation.NACIONALIDADServiceImpl;
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
@RequestMapping("/nacionalidad")
@RequiredArgsConstructor
public class NACIONALIDADResource {
    private final NACIONALIDADServiceImpl nacionalidadService;
    @GetMapping("/list")
    public ResponseEntity<Response> getNACIONALIDAD() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("NACIONALIDAD",nacionalidadService.list(30)))
                        .message("NACIONALIDAD retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<NACIONALIDAD> getSimpleNACIONALIDAD()  {
        return nacionalidadService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveNACIONALIDAD(@RequestBody @Valid NACIONALIDAD nacionalidad) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("NACIONALIDAD",nacionalidadService.create(nacionalidad)))
                        .message("NACIONALIDAD created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getNACIONALIDAD(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("NACIONALIDAD",nacionalidadService.get(id)))
                        .message("NACIONALIDAD retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteNACIONALIDAD(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",nacionalidadService.delete(id)))
                        .message("NACIONALIDAD deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

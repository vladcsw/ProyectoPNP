package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.MODALIDAD;
import com.example.demo.service.implementation.MODALIDADServiceImpl;
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
@RequestMapping("/modalidad")
@RequiredArgsConstructor
public class MODALIDADResource {
    private final MODALIDADServiceImpl modalidadService;
    @GetMapping("/list")
    public ResponseEntity<Response> getMODALIDAD() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("MODALIDAD",modalidadService.list(30)))
                        .message("MODALIDAD retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<MODALIDAD> getSimpleMODALIDAD()  {
        return modalidadService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveMODALIDAD(@RequestBody @Valid MODALIDAD modalidad) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("MODALIDAD",modalidadService.create(modalidad)))
                        .message("MODALIDAD created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getMODALIDAD(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("MODALIDAD",modalidadService.get(id)))
                        .message("MODALIDAD retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteMODALIDAD(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",modalidadService.delete(id)))
                        .message("MODALIDAD deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.MODALIDAD_EMPLEADA;
import com.example.demo.service.implementation.MODALIDAD_EMPLEADAServiceImpl;
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
@RequestMapping("/modalidad_empleada")
@RequiredArgsConstructor
public class MODALIDAD_EMPLEADAResource {
    private final MODALIDAD_EMPLEADAServiceImpl modalidad_empleadaService;
    @GetMapping("/list")
    public ResponseEntity<Response> getMODALIDAD_EMPLEADA() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("MODALIDAD_EMPLEADA",modalidad_empleadaService.list(30)))
                        .message("MODALIDAD_EMPLEADA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<MODALIDAD_EMPLEADA> getSimpleMODALIDAD_EMPLEADA()  {
        return modalidad_empleadaService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveMODALIDAD_EMPLEADA(@RequestBody @Valid MODALIDAD_EMPLEADA modalidad_empleada) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("MODALIDAD_EMPLEADA",modalidad_empleadaService.create(modalidad_empleada)))
                        .message("MODALIDAD_EMPLEADA created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getMODALIDAD_EMPLEADA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("MODALIDAD_EMPLEADA",modalidad_empleadaService.get(id)))
                        .message("MODALIDAD_EMPLEADA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteMODALIDAD_EMPLEADA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",modalidad_empleadaService.delete(id)))
                        .message("MODALIDAD_EMPLEADA deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

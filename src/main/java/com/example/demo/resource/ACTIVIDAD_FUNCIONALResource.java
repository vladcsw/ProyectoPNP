package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.ACTIVIDAD_FUNCIONAL;
import com.example.demo.service.implementation.ACTIVIDAD_FUNCIONALServiceImpl;
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
@RequestMapping("/actividad_funcional")
@RequiredArgsConstructor
public class ACTIVIDAD_FUNCIONALResource {
    private final ACTIVIDAD_FUNCIONALServiceImpl actividad_funcionalService;
    @GetMapping("/list")
    public ResponseEntity<Response> getACTIVIDAD_FUNCIONAL() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("ACTIVIDAD_FUNCIONAL",actividad_funcionalService.list(30)))
                        .message("ACTIVIDAD_FUNCIONAL retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<ACTIVIDAD_FUNCIONAL> getSimpleACTIVIDAD_FUNCIONAL()  {
        return actividad_funcionalService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveACTIVIDAD_FUNCIONAL(@RequestBody @Valid ACTIVIDAD_FUNCIONAL actividad_funcional) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("ACTIVIDAD_FUNCIONAL",actividad_funcionalService.create(actividad_funcional)))
                        .message("ACTIVIDAD_FUNCIONAL created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getACTIVIDAD_FUNCIONAL(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("ACTIVIDAD_FUNCIONAL",actividad_funcionalService.get(id)))
                        .message("ACTIVIDAD_FUNCIONAL retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteACTIVIDAD_FUNCIONAL(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",actividad_funcionalService.delete(id)))
                        .message("ACTIVIDAD_FUNCIONAL deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
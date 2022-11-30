package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.UNIDAD_NODO;
import com.example.demo.service.implementation.UNIDAD_NODOServiceImpl;
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
@RequestMapping("/unidad_nodo")
@RequiredArgsConstructor
public class UNIDAD_NODOResource {
    private final UNIDAD_NODOServiceImpl unidad_nodoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getUNIDAD_NODO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("UNIDAD_NODO",unidad_nodoService.list(30)))
                        .message("UNIDAD_NODO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<UNIDAD_NODO> getSimpleUNIDAD_NODO()  {
        return unidad_nodoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveUNIDAD_NODO(@RequestBody @Valid UNIDAD_NODO unidad_nodo) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("UNIDAD_NODO",unidad_nodoService.create(unidad_nodo)))
                        .message("UNIDAD_NODO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getUNIDAD_NODO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("UNIDAD_NODO",unidad_nodoService.get(id)))
                        .message("UNIDAD_NODO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteUNIDAD_NODO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",unidad_nodoService.delete(id)))
                        .message("UNIDAD_NODO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

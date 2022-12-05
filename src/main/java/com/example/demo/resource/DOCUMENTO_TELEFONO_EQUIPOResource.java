package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.DOCUMENTO_TELEFONO_EQUIPO;
import com.example.demo.service.implementation.DOCUMENTO_TELEFONO_EQUIPOServiceImpl;
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
@RequestMapping("/documento_telefono_equipo")
@RequiredArgsConstructor
public class DOCUMENTO_TELEFONO_EQUIPOResource {
    private final DOCUMENTO_TELEFONO_EQUIPOServiceImpl documento_telefono_equipoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getDOCUMENTO_TELEFONO_EQUIPO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_TELEFONO_EQUIPO",documento_telefono_equipoService.list(30)))
                        .message("DOCUMENTO_TELEFONO_EQUIPO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<DOCUMENTO_TELEFONO_EQUIPO> getSimpleDOCUMENTO_TELEFONO_EQUIPO()  {
        return documento_telefono_equipoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveDOCUMENTO_TELEFONO_EQUIPO(@RequestBody @Valid DOCUMENTO_TELEFONO_EQUIPO documento_telefono_equipo) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_TELEFONO_EQUIPO",documento_telefono_equipoService.create(documento_telefono_equipo)))
                        .message("DOCUMENTO_TELEFONO_EQUIPO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getDOCUMENTO_TELEFONO_EQUIPO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_TELEFONO_EQUIPO",documento_telefono_equipoService.get(id)))
                        .message("DOCUMENTO_TELEFONO_EQUIPO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteDOCUMENTO_TELEFONO_EQUIPO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",documento_telefono_equipoService.delete(id)))
                        .message("DOCUMENTO_TELEFONO_EQUIPO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

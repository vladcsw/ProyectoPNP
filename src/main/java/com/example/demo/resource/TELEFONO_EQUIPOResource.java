package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.TELEFONO_EQUIPO;
import com.example.demo.service.implementation.TELEFONO_EQUIPOServiceImpl;
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
@RequestMapping("/telefono_equipo")
@RequiredArgsConstructor
public class TELEFONO_EQUIPOResource {
    private final TELEFONO_EQUIPOServiceImpl telefono_equipoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getTELEFONO_EQUIPO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("TELEFONO_EQUIPO",telefono_equipoService.list(30)))
                        .message("TELEFONO_EQUIPO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<TELEFONO_EQUIPO> getSimpleTELEFONO_EQUIPO()  {
        return telefono_equipoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveTELEFONO_EQUIPO(@RequestBody @Valid TELEFONO_EQUIPO telefono_equipo) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("TELEFONO_EQUIPO",telefono_equipoService.create(telefono_equipo)))
                        .message("TELEFONO_EQUIPO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getTELEFONO_EQUIPO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("TELEFONO_EQUIPO",telefono_equipoService.get(id)))
                        .message("TELEFONO_EQUIPO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteTELEFONO_EQUIPO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",telefono_equipoService.delete(id)))
                        .message("TELEFONO_EQUIPO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

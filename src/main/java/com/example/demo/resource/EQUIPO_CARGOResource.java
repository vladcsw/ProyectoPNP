package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.EQUIPO_CARGO;
import com.example.demo.service.implementation.EQUIPO_CARGOServiceImpl;
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
@RequestMapping("/equipo_cargo")
@RequiredArgsConstructor
public class EQUIPO_CARGOResource {
    private final EQUIPO_CARGOServiceImpl equipo_cargoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getEQUIPO_CARGO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("EQUIPO_CARGO",equipo_cargoService.list(30)))
                        .message("EQUIPO_CARGO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<EQUIPO_CARGO> getSimpleEQUIPO_CARGO()  {
        return equipo_cargoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveEQUIPO_CARGO(@RequestBody @Valid EQUIPO_CARGO equipo_cargo) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("EQUIPO_CARGO",equipo_cargoService.create(equipo_cargo)))
                        .message("EQUIPO_CARGO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getEQUIPO_CARGO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("EQUIPO_CARGO",equipo_cargoService.get(id)))
                        .message("EQUIPO_CARGO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteEQUIPO_CARGO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",equipo_cargoService.delete(id)))
                        .message("EQUIPO_CARGO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
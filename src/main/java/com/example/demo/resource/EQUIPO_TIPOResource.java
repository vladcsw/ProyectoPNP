package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.EQUIPO_TIPO;
import com.example.demo.service.implementation.EQUIPO_TIPOServiceImpl;
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
@RequestMapping("/equipo_tipo")
@RequiredArgsConstructor
public class EQUIPO_TIPOResource {
    private final EQUIPO_TIPOServiceImpl equipo_tipoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getEQUIPO_TIPO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("EQUIPO_TIPO",equipo_tipoService.list(30)))
                        .message("EQUIPO_TIPO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<EQUIPO_TIPO> getSimpleEQUIPO_TIPO()  {
        return equipo_tipoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveEQUIPO_TIPO(@RequestBody @Valid EQUIPO_TIPO equipo_tipo) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("EQUIPO_TIPO",equipo_tipoService.create(equipo_tipo)))
                        .message("EQUIPO_TIPO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getEQUIPO_TIPO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("EQUIPO_TIPO",equipo_tipoService.get(id)))
                        .message("EQUIPO_TIPO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteEQUIPO_TIPO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",equipo_tipoService.delete(id)))
                        .message("EQUIPO_TIPO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
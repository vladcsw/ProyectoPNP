package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.TELEFONO;
import com.example.demo.service.implementation.TELEFONOServiceImpl;
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
@RequestMapping("/telefono")
@RequiredArgsConstructor
public class TELEFONOResource {
    private final TELEFONOServiceImpl telefonoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getTELEFONO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("TELEFONO",telefonoService.list(30)))
                        .message("TELEFONO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<TELEFONO> getSimpleTELEFONO()  {
        return telefonoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveTELEFONO(@RequestBody @Valid TELEFONO telefono) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("TELEFONO",telefonoService.create(telefono)))
                        .message("TELEFONO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getTELEFONO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("TELEFONO",telefonoService.get(id)))
                        .message("TELEFONO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteTELEFONO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",telefonoService.delete(id)))
                        .message("TELEFONO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

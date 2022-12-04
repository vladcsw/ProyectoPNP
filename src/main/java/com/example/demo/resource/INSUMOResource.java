package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.INSUMO;
import com.example.demo.service.implementation.INSUMOServiceImpl;
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
@RequestMapping("/insumo")
@RequiredArgsConstructor
public class INSUMOResource {
    private final INSUMOServiceImpl insumoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getINSUMO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("INSUMO",insumoService.list(30)))
                        .message("INSUMO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<INSUMO> getSimpleINSUMO()  {
        return insumoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveINSUMO(@RequestBody @Valid INSUMO insumo) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("INSUMO",insumoService.create(insumo)))
                        .message("INSUMO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getINSUMO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("INSUMO",insumoService.get(id)))
                        .message("INSUMO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteINSUMO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",insumoService.delete(id)))
                        .message("INSUMO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

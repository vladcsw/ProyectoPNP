package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.CARACTERISTICA_TIPO;
import com.example.demo.service.implementation.CARACTERISTICA_TIPOServiceImpl;
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
@RequestMapping("/caracteristica_tipo")
@RequiredArgsConstructor
public class CARACTERISTICA_TIPOResource {
    private final CARACTERISTICA_TIPOServiceImpl caracteristica_tipoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getCARACTERISTICA_TIPO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("CARACTERISTICA_TIPO",caracteristica_tipoService.list(30)))
                        .message("CARACTERISTICA_TIPO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<CARACTERISTICA_TIPO> getSimpleCARACTERISTICA_TIPO()  {
        return caracteristica_tipoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveCARACTERISTICA_TIPO(@RequestBody @Valid CARACTERISTICA_TIPO caracteristica_tipo) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("CARACTERISTICA_TIPO",caracteristica_tipoService.create(caracteristica_tipo)))
                        .message("CARACTERISTICA_TIPO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getCARACTERISTICA_TIPO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("CARACTERISTICA_TIPO",caracteristica_tipoService.get(id)))
                        .message("CARACTERISTICA_TIPO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteCARACTERISTICA_TIPO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",caracteristica_tipoService.delete(id)))
                        .message("CARACTERISTICA_TIPO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
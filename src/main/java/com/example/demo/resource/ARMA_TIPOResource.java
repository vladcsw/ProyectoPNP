package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.ARMA_TIPO;
import com.example.demo.service.implementation.ARMA_TIPOServiceImpl;
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
@RequestMapping("/arma_tipo")
@RequiredArgsConstructor
public class ARMA_TIPOResource {
    private final ARMA_TIPOServiceImpl arma_tipoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getARMA_TIPO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("ARMA_TIPO",arma_tipoService.list(30)))
                        .message("ARMA_TIPO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<ARMA_TIPO> getSimpleARMA_TIPO()  {
        return arma_tipoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveARMA_TIPO(@RequestBody @Valid ARMA_TIPO arma_tipo) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("ARMA_TIPO",arma_tipoService.create(arma_tipo)))
                        .message("ARMA_TIPO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getARMA_TIPO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("ARMA_TIPO",arma_tipoService.get(id)))
                        .message("ARMA_TIPO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteARMA_TIPO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",arma_tipoService.delete(id)))
                        .message("ARMA_TIPO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

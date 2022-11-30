package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.PEDIDO;
import com.example.demo.service.implementation.PEDIDOServiceImpl;
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
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PEDIDOResource {
    private final PEDIDOServiceImpl pedidoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getPEDIDO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("PEDIDO",pedidoService.list(30)))
                        .message("PEDIDO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<PEDIDO> getSimplePEDIDO()  {
        return pedidoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> savePEDIDO(@RequestBody @Valid PEDIDO pedido) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("PEDIDO",pedidoService.create(pedido)))
                        .message("PEDIDO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getPEDIDO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("PEDIDO",pedidoService.get(id)))
                        .message("PEDIDO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deletePEDIDO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",pedidoService.delete(id)))
                        .message("PEDIDO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

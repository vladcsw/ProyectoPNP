package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.CARGO_PNP;
import com.example.demo.service.implementation.CARGO_PNPServiceImpl;
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
@RequestMapping("/cargo_pnp")
@RequiredArgsConstructor
public class CARGO_PNPResource {
    private final CARGO_PNPServiceImpl cargo_pnpService;
    @GetMapping("/list")
    public ResponseEntity<Response> getCARGO_PNP() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("CARGO_PNP",cargo_pnpService.list(30)))
                        .message("CARGO_PNP retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<CARGO_PNP> getSimpleCARGO_PNP()  {
        return cargo_pnpService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveCARGO_PNP(@RequestBody @Valid CARGO_PNP cargo_pnp) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("CARGO_PNP",cargo_pnpService.create(cargo_pnp)))
                        .message("CARGO_PNP created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getCARGO_PNP(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("CARGO_PNP",cargo_pnpService.get(id)))
                        .message("CARGO_PNP retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteCARGO_PNP(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",cargo_pnpService.delete(id)))
                        .message("CARGO_PNP deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

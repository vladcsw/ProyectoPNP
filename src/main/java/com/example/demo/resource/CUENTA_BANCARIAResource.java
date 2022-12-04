package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.CUENTA_BANCARIA;
import com.example.demo.service.implementation.CUENTA_BANCARIAServiceImpl;
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
@RequestMapping("/cuenta_bancaria")
@RequiredArgsConstructor
public class CUENTA_BANCARIAResource {
    private final CUENTA_BANCARIAServiceImpl cuenta_bancariaService;
    @GetMapping("/list")
    public ResponseEntity<Response> getCUENTA_BANCARIA() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("CUENTA_BANCARIA",cuenta_bancariaService.list(30)))
                        .message("CUENTA_BANCARIA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<CUENTA_BANCARIA> getSimpleCUENTA_BANCARIA()  {
        return cuenta_bancariaService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveCUENTA_BANCARIA(@RequestBody @Valid CUENTA_BANCARIA cuenta_bancaria) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("CUENTA_BANCARIA",cuenta_bancariaService.create(cuenta_bancaria)))
                        .message("CUENTA_BANCARIA created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getCUENTA_BANCARIA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("CUENTA_BANCARIA",cuenta_bancariaService.get(id)))
                        .message("CUENTA_BANCARIA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteCUENTA_BANCARIA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",cuenta_bancariaService.delete(id)))
                        .message("CUENTA_BANCARIA deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.DOCUMENTO_CUENTA_BANCARIA;
import com.example.demo.service.implementation.DOCUMENTO_CUENTA_BANCARIAServiceImpl;
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
@RequestMapping("/documento_cuenta_bancaria")
@RequiredArgsConstructor
public class DOCUMENTO_CUENTA_BANCARIAResource {
    private final DOCUMENTO_CUENTA_BANCARIAServiceImpl documento_cuenta_bancariaService;
    @GetMapping("/list")
    public ResponseEntity<Response> getDOCUMENTO_CUENTA_BANCARIA() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_CUENTA_BANCARIA",documento_cuenta_bancariaService.list(30)))
                        .message("DOCUMENTO_CUENTA_BANCARIA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<DOCUMENTO_CUENTA_BANCARIA> getSimpleDOCUMENTO_CUENTA_BANCARIA()  {
        return documento_cuenta_bancariaService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveDOCUMENTO_CUENTA_BANCARIA(@RequestBody @Valid DOCUMENTO_CUENTA_BANCARIA documento_cuenta_bancaria) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_CUENTA_BANCARIA",documento_cuenta_bancariaService.create(documento_cuenta_bancaria)))
                        .message("DOCUMENTO_CUENTA_BANCARIA created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getDOCUMENTO_CUENTA_BANCARIA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_CUENTA_BANCARIA",documento_cuenta_bancariaService.get(id)))
                        .message("DOCUMENTO_CUENTA_BANCARIA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteDOCUMENTO_CUENTA_BANCARIA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",documento_cuenta_bancariaService.delete(id)))
                        .message("DOCUMENTO_CUENTA_BANCARIA deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

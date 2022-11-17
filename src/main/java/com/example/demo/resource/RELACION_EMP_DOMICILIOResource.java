package com.example.demo.resource;

import com.example.demo.model.PERSONA;
import com.example.demo.model.Response;
import com.example.demo.model.RELACION_EMP_DOMICILIO;
import com.example.demo.service.implementation.RELACION_EMP_DOMICILIOServiceImpl;
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
@RequestMapping("/relacion_emp_domicilio")
@RequiredArgsConstructor
public class RELACION_EMP_DOMICILIOResource {
    private final RELACION_EMP_DOMICILIOServiceImpl relacion_emp_domicilioService;
    @GetMapping("/list")
    public ResponseEntity<Response> getRELACION_EMP_DOMICILIOs() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("relacion_emp_domicilios",relacion_emp_domicilioService.list(30)))
                        .message("RELACION_EMP_DOMICILIOs retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<RELACION_EMP_DOMICILIO> getRELACION_PER_EMPRESAss()  {
        return relacion_emp_domicilioService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveRELACION_EMP_DOMICILIO(@RequestBody @Valid RELACION_EMP_DOMICILIO relacion_emp_domicilio) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("relacion_emp_domicilio",relacion_emp_domicilioService.create(relacion_emp_domicilio)))
                        .message("RELACION_EMP_DOMICILIO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getRELACION_EMP_DOMICILIO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("relacion_emp_domicilio",relacion_emp_domicilioService.get(id)))
                        .message("RELACION_EMP_DOMICILIO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteRELACION_EMP_DOMICILIO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",relacion_emp_domicilioService.delete(id)))
                        .message("RELACION_EMP_DOMICILIO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }


}

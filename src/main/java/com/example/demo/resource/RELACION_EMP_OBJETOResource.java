package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.RELACION_EMP_OBJETO;
import com.example.demo.service.implementation.RELACION_EMP_OBJETOServiceImpl;
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
@RequestMapping("/relacion_emp_objeto")
@RequiredArgsConstructor
public class RELACION_EMP_OBJETOResource {
    private final RELACION_EMP_OBJETOServiceImpl relacion_emp_objetoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getRELACION_EMP_OBJETO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("RELACION_EMP_OBJETO",relacion_emp_objetoService.list(30)))
                        .message("RELACION_EMP_OBJETO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<RELACION_EMP_OBJETO> getSimpleRELACION_EMP_OBJETO()  {
        return relacion_emp_objetoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveRELACION_EMP_OBJETO(@RequestBody @Valid RELACION_EMP_OBJETO relacion_emp_objeto) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("RELACION_EMP_OBJETO",relacion_emp_objetoService.create(relacion_emp_objeto)))
                        .message("RELACION_EMP_OBJETO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getRELACION_EMP_OBJETO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("RELACION_EMP_OBJETO",relacion_emp_objetoService.get(id)))
                        .message("RELACION_EMP_OBJETO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteRELACION_EMP_OBJETO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",relacion_emp_objetoService.delete(id)))
                        .message("RELACION_EMP_OBJETO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.RELACION_TIPO;
import com.example.demo.service.implementation.RELACION_TIPOServiceImpl;
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
@RequestMapping("/relacion_tipo")
@RequiredArgsConstructor
public class RELACION_TIPOResource {
    private final RELACION_TIPOServiceImpl relacion_tipoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getRELACION_TIPO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("RELACION_TIPO",relacion_tipoService.list(30)))
                        .message("RELACION_TIPO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<RELACION_TIPO> getSimpleRELACION_TIPO()  {
        return relacion_tipoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveRELACION_TIPO(@RequestBody @Valid RELACION_TIPO relacion_tipo) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("RELACION_TIPO",relacion_tipoService.create(relacion_tipo)))
                        .message("RELACION_TIPO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getRELACION_TIPO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("RELACION_TIPO",relacion_tipoService.get(id)))
                        .message("RELACION_TIPO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteRELACION_TIPO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",relacion_tipoService.delete(id)))
                        .message("RELACION_TIPO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
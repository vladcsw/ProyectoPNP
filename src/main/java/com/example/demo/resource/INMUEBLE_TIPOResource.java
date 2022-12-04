package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.INMUEBLE_TIPO;
import com.example.demo.service.implementation.INMUEBLE_TIPOServiceImpl;
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
@RequestMapping("/inmueble_tipo")
@RequiredArgsConstructor
public class INMUEBLE_TIPOResource {
    private final INMUEBLE_TIPOServiceImpl inmueble_tipoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getINMUEBLE_TIPO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("INMUEBLE_TIPO",inmueble_tipoService.list(30)))
                        .message("INMUEBLE_TIPO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<INMUEBLE_TIPO> getSimpleINMUEBLE_TIPO()  {
        return inmueble_tipoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveINMUEBLE_TIPO(@RequestBody @Valid INMUEBLE_TIPO inmueble_tipo) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("INMUEBLE_TIPO",inmueble_tipoService.create(inmueble_tipo)))
                        .message("INMUEBLE_TIPO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getINMUEBLE_TIPO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("INMUEBLE_TIPO",inmueble_tipoService.get(id)))
                        .message("INMUEBLE_TIPO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteINMUEBLE_TIPO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",inmueble_tipoService.delete(id)))
                        .message("INMUEBLE_TIPO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.MODALIDAD_TIPO;
import com.example.demo.service.implementation.MODALIDAD_TIPOServiceImpl;
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
@RequestMapping("/modalidad_tipo")
@RequiredArgsConstructor
public class MODALIDAD_TIPOResource {
    private final MODALIDAD_TIPOServiceImpl modalidad_tipoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getMODALIDAD_TIPO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("MODALIDAD_TIPO",modalidad_tipoService.list(30)))
                        .message("MODALIDAD_TIPO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<MODALIDAD_TIPO> getSimpleMODALIDAD_TIPO()  {
        return modalidad_tipoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveMODALIDAD_TIPO(@RequestBody @Valid MODALIDAD_TIPO modalidad_tipo) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("MODALIDAD_TIPO",modalidad_tipoService.create(modalidad_tipo)))
                        .message("MODALIDAD_TIPO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getMODALIDAD_TIPO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("MODALIDAD_TIPO",modalidad_tipoService.get(id)))
                        .message("MODALIDAD_TIPO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteMODALIDAD_TIPO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",modalidad_tipoService.delete(id)))
                        .message("MODALIDAD_TIPO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.UNIDAD_PNP;
import com.example.demo.service.implementation.UNIDAD_PNPServiceImpl;
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
@RequestMapping("/unidad_pnp")
@RequiredArgsConstructor
public class UNIDAD_PNPResource {
    private final UNIDAD_PNPServiceImpl unidad_pnpService;
    @GetMapping("/list")
    public ResponseEntity<Response> getUNIDAD_PNP() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("UNIDAD_PNP",unidad_pnpService.list(30)))
                        .message("UNIDAD_PNP retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<UNIDAD_PNP> getSimpleUNIDAD_PNP()  {
        return unidad_pnpService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveUNIDAD_PNP(@RequestBody @Valid UNIDAD_PNP unidad_pnp) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("UNIDAD_PNP",unidad_pnpService.create(unidad_pnp)))
                        .message("UNIDAD_PNP created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getUNIDAD_PNP(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("UNIDAD_PNP",unidad_pnpService.get(id)))
                        .message("UNIDAD_PNP retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteUNIDAD_PNP(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",unidad_pnpService.delete(id)))
                        .message("UNIDAD_PNP deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
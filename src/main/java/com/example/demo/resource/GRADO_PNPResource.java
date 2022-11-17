package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.GRADO_PNP;
import com.example.demo.service.implementation.GRADO_PNPServiceImpl;
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
@RequestMapping("/grado_pnp")
@RequiredArgsConstructor
public class GRADO_PNPResource {
    private final GRADO_PNPServiceImpl grado_pnpService;
    @GetMapping("/list")
    public ResponseEntity<Response> getGRADO_PNP() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("GRADO_PNP",grado_pnpService.list(30)))
                        .message("GRADO_PNP retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<GRADO_PNP> getSimpleGRADO_PNP()  {
        return grado_pnpService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveGRADO_PNP(@RequestBody @Valid GRADO_PNP grado_pnp) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("GRADO_PNP",grado_pnpService.create(grado_pnp)))
                        .message("GRADO_PNP created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getGRADO_PNP(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("GRADO_PNP",grado_pnpService.get(id)))
                        .message("GRADO_PNP retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteGRADO_PNP(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",grado_pnpService.delete(id)))
                        .message("GRADO_PNP deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
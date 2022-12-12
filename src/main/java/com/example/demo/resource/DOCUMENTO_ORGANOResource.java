package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.DOCUMENTO_ORGANO;
import com.example.demo.service.implementation.DOCUMENTO_ORGANOServiceImpl;
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
@RequestMapping("/documento_organo")
@RequiredArgsConstructor
public class DOCUMENTO_ORGANOResource {
    private final DOCUMENTO_ORGANOServiceImpl documento_organoService;
    @GetMapping("/list")
    public ResponseEntity<Response> getDOCUMENTO_ORGANO() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_ORGANO",documento_organoService.list(30)))
                        .message("DOCUMENTO_ORGANO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<DOCUMENTO_ORGANO> getSimpleDOCUMENTO_ORGANO()  {
        return documento_organoService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveDOCUMENTO_ORGANO(@RequestBody @Valid DOCUMENTO_ORGANO documento_organo) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_ORGANO",documento_organoService.create(documento_organo)))
                        .message("DOCUMENTO_ORGANO created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getDOCUMENTO_ORGANO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_ORGANO",documento_organoService.get(id)))
                        .message("DOCUMENTO_ORGANO retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteDOCUMENTO_ORGANO(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",documento_organoService.delete(id)))
                        .message("DOCUMENTO_ORGANO deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

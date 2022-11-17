package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.DOCUMENTO_PERSONAL_PNP;
import com.example.demo.service.implementation.DOCUMENTO_PERSONAL_PNPServiceImpl;
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
@RequestMapping("/documento_personal_pnp")
@RequiredArgsConstructor
public class DOCUMENTO_PERSONAL_PNPResource {
    private final DOCUMENTO_PERSONAL_PNPServiceImpl documento_personal_pnpService;
    @GetMapping("/list")
    public ResponseEntity<Response> getDOCUMENTO_PERSONAL_PNP() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_PERSONAL_PNP",documento_personal_pnpService.list(30)))
                        .message("DOCUMENTO_PERSONAL_PNP retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<DOCUMENTO_PERSONAL_PNP> getSimpleDOCUMENTO_PERSONAL_PNP()  {
        return documento_personal_pnpService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveDOCUMENTO_PERSONAL_PNP(@RequestBody @Valid DOCUMENTO_PERSONAL_PNP documento_personal_pnp) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_PERSONAL_PNP",documento_personal_pnpService.create(documento_personal_pnp)))
                        .message("DOCUMENTO_PERSONAL_PNP created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getDOCUMENTO_PERSONAL_PNP(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_PERSONAL_PNP",documento_personal_pnpService.get(id)))
                        .message("DOCUMENTO_PERSONAL_PNP retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteDOCUMENTO_PERSONAL_PNP(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",documento_personal_pnpService.delete(id)))
                        .message("DOCUMENTO_PERSONAL_PNP deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
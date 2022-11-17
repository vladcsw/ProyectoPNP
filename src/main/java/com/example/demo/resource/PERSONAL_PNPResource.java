package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.PERSONAL_PNP;
import com.example.demo.service.implementation.PERSONAL_PNPServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/personal_pnp")
@RequiredArgsConstructor
public class PERSONAL_PNPResource {
    private final PERSONAL_PNPServiceImpl personal_pnpService;
    @GetMapping("/list")
    public ResponseEntity<Response> getPERSONAL_PNPs() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("personal_pnps",personal_pnpService.list(30)))
                        .message("PERSONAL_PNPs retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> savePERSONAL_PNP(@RequestBody @Valid PERSONAL_PNP personal_pnp) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("personal_pnp",personal_pnpService.create(personal_pnp)))
                        .message("PERSONAL_PNP created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getPERSONAL_PNP(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("personal_pnp",personal_pnpService.get(id)))
                        .message("PERSONAL_PNP retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deletePERSONAL_PNP(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",personal_pnpService.delete(id)))
                        .message("PERSONAL_PNP deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }


}

package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.RELACION_ORIGEN;
import com.example.demo.service.implementation.RELACION_ORIGENServiceImpl;
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
@RequestMapping("/relacion_origen")
@RequiredArgsConstructor
public class RELACION_ORIGENResource {
    private final RELACION_ORIGENServiceImpl relacion_origenService;
    @GetMapping("/list")
    public ResponseEntity<Response> getRELACION_ORIGEN() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("RELACION_ORIGEN",relacion_origenService.list(30)))
                        .message("RELACION_ORIGEN retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<RELACION_ORIGEN> getSimpleRELACION_ORIGEN()  {
        return relacion_origenService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveRELACION_ORIGEN(@RequestBody @Valid RELACION_ORIGEN relacion_origen) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("RELACION_ORIGEN",relacion_origenService.create(relacion_origen)))
                        .message("RELACION_ORIGEN created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getRELACION_ORIGEN(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("RELACION_ORIGEN",relacion_origenService.get(id)))
                        .message("RELACION_ORIGEN retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteRELACION_ORIGEN(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",relacion_origenService.delete(id)))
                        .message("RELACION_ORIGEN deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

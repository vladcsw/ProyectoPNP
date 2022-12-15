package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.PROVINCIA;
import com.example.demo.repo.PROVINCIARepo;
import com.example.demo.service.implementation.PROVINCIAServiceImpl;
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
@RequestMapping("/provincia")
@RequiredArgsConstructor
public class PROVINCIAResource {
    private final PROVINCIAServiceImpl provinciaService;
    private final PROVINCIARepo pROVINCIARepo;

    @GetMapping("/list")
    public ResponseEntity<Response> getPROVINCIA() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("PROVINCIA",provinciaService.list(30)))
                        .message("PROVINCIA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<PROVINCIA> getSimplePROVINCIA()  {
        return provinciaService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> savePROVINCIA(@RequestBody @Valid PROVINCIA provincia) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("PROVINCIA",provinciaService.create(provincia)))
                        .message("PROVINCIA created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getPROVINCIA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("PROVINCIA",provinciaService.get(id)))
                        .message("PROVINCIA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deletePROVINCIA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",provinciaService.delete(id)))
                        .message("PROVINCIA deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/prueba")
    public ResponseEntity<Response> prueba(  @RequestParam String id2, @RequestBody PROVINCIA provincia){
        System.out.println("provin"+id2);
        System.out.println(provincia);

        //System.out.println(provincia);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted","provinciaService.delete(id)"))
                        .message("PROVINCIA deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

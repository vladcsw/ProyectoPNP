package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.DOCUMENTO_AGENDA;
import com.example.demo.service.implementation.DOCUMENTO_AGENDAServiceImpl;
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
@RequestMapping("/documento_agenda")
@RequiredArgsConstructor
public class DOCUMENTO_AGENDAResource {
    private final DOCUMENTO_AGENDAServiceImpl documento_agendaService;
    @GetMapping("/list")
    public ResponseEntity<Response> getDOCUMENTO_AGENDA() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_AGENDA",documento_agendaService.list(30)))
                        .message("DOCUMENTO_AGENDA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<DOCUMENTO_AGENDA> getSimpleDOCUMENTO_AGENDA()  {
        return documento_agendaService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveDOCUMENTO_AGENDA(@RequestBody @Valid DOCUMENTO_AGENDA documento_agenda) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_AGENDA",documento_agendaService.create(documento_agenda)))
                        .message("DOCUMENTO_AGENDA created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getDOCUMENTO_AGENDA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("DOCUMENTO_AGENDA",documento_agendaService.get(id)))
                        .message("DOCUMENTO_AGENDA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteDOCUMENTO_AGENDA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",documento_agendaService.delete(id)))
                        .message("DOCUMENTO_AGENDA deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.AGENDA;
import com.example.demo.service.implementation.AGENDAServiceImpl;
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
@RequestMapping("/agenda")
@RequiredArgsConstructor
public class AGENDAResource {
    private final AGENDAServiceImpl agendaService;
    @GetMapping("/list")
    public ResponseEntity<Response> getAGENDA() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("AGENDA",agendaService.list(30)))
                        .message("AGENDA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<AGENDA> getSimpleAGENDA()  {
        return agendaService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveAGENDA(@RequestBody @Valid AGENDA agenda) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("AGENDA",agendaService.create(agenda)))
                        .message("AGENDA created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getAGENDA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("AGENDA",agendaService.get(id)))
                        .message("AGENDA retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteAGENDA(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",agendaService.delete(id)))
                        .message("AGENDA deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}

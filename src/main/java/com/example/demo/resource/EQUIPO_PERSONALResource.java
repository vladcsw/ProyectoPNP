package com.example.demo.resource;

import com.example.demo.model.Response;
import com.example.demo.model.EQUIPO_PERSONAL;
import com.example.demo.service.implementation.EQUIPO_PERSONALServiceImpl;
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
@RequestMapping("/equipo_personal")
@RequiredArgsConstructor
public class EQUIPO_PERSONALResource {
    private final EQUIPO_PERSONALServiceImpl equipo_personalService;
    @GetMapping("/list")
    public ResponseEntity<Response> getEQUIPO_PERSONAL() throws InterruptedException {
        //throw new InterruptedException("Something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("EQUIPO_PERSONAL",equipo_personalService.list(30)))
                        .message("EQUIPO_PERSONAL retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/lista")
    public Collection<EQUIPO_PERSONAL> getSimpleEQUIPO_PERSONAL()  {
        return equipo_personalService.list(30);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveEQUIPO_PERSONAL(@RequestBody @Valid EQUIPO_PERSONAL equipo_personal) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("EQUIPO_PERSONAL",equipo_personalService.create(equipo_personal)))
                        .message("EQUIPO_PERSONAL created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getEQUIPO_PERSONAL(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("EQUIPO_PERSONAL",equipo_personalService.get(id)))
                        .message("EQUIPO_PERSONAL retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteEQUIPO_PERSONAL(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",equipo_personalService.delete(id)))
                        .message("EQUIPO_PERSONAL deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
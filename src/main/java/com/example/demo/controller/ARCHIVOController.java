package com.example.demo.controller;

import com.example.demo.model.ACTIVIDAD_FUNCIONAL;
import com.example.demo.model.ARCHIVO;
import com.example.demo.model.DOCUMENTO_PERSONA;
import com.example.demo.model.PERSONA;
import com.example.demo.repo.ARCHIVORepo;
import com.example.demo.service.ARCHIVOService;
import com.example.demo.service.implementation.ARCHIVOServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
public class ARCHIVOController {
    @Autowired
    ARCHIVOService fileService;
    @Autowired
    ARCHIVOServiceImpl archivoServiceImpl;
    @Autowired
    ARCHIVORepo repo;
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFiles(@RequestPart("files") MultipartFile[] files,  @RequestPart("archivo")String archivox){
        //ARCHIVO x = archivox;
        //ARCHIVO x = (ARCHIVO) archivox;
        //ARCHIVO x = new ARCHIVO(null, archivox, )
        //System.out.println(archivo);
        System.out.print(archivox);
        //archivoServiceImpl.create(x);
        String message = "";
        try{
            List<String> fileNames = new ArrayList<>();

            Arrays.asList(files).stream().forEach(file->{
                LocalDateTime x = LocalDateTime.now();
                String f = Integer.toString(x.getYear())+Integer.toString(x.getDayOfMonth())+Integer.toString(x.getDayOfMonth())+Integer.toString(x.getHour())+Integer.toString(x.getMinute())+Integer.toString(x.getSecond());
                fileService.save(file, f);
                String url = MvcUriComponentsBuilder.fromMethodName(ARCHIVOController.class, "getFile",
                        f+file.getOriginalFilename()).build().toString();
                //url = url.substring(0, 4) + "s" + url.substring(4, url.length());
                System.out.println(url);
                repo.save(new ARCHIVO(null, f+file.getOriginalFilename(), url, Long.parseLong(archivox)));
                fileNames.add(file.getOriginalFilename());
            });

            message = "Se subieron los archivos correctamente " + fileNames;
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }catch (Exception e){
            message = "Fallo al subir los archivos";
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);

        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<String>> getFiles(){
        List<String> fileInfos = fileService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder.fromMethodName(ARCHIVOController.class, "getFile",
                    path.getFileName().toString()).build().toString();
            return filename+":"+url;
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }


    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename){
        Resource file = fileService.load(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\""+file.getFilename() + "\"").body(file);
    }

    @GetMapping("/delete/{filename:.+}")
    public ResponseEntity<String> deleteFile(@PathVariable String filename) {
        String message = "";
        try {
            message = fileService.deleteFile(filename);
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }
    @GetMapping("/archivo/documento/{id}")
    public Collection<ARCHIVO> getPERSONA(@PathVariable("id") Long id){
        return archivoServiceImpl.list(id);
    }


}

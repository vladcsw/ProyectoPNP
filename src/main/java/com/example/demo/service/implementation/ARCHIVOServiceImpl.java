package com.example.demo.service.implementation;

import com.example.demo.model.ARCHIVO;
import com.example.demo.repo.ARCHIVORepo;
import com.example.demo.service.ARCHIVOService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.stream.Stream;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ARCHIVOServiceImpl implements ARCHIVOService {
    private final Path root = Paths.get("uploads");
    private final ARCHIVORepo archivoRepo;
    @Override
    public void init() {
        try {
            if (!Files.exists(root))
                Files.createDirectory(root);
        } catch (IOException e) {
            throw new RuntimeException("No se puede inicializar la carpeta uploads");
        }
    }

    @Override
    public void save(MultipartFile file, String fecha) {
        try {

            //copy (que queremos copiar, a donde queremos copiar)
            Files.copy(file.getInputStream(),
                    this.root.resolve(fecha+file.getOriginalFilename()));
        } catch (IOException e) {
            throw new RuntimeException("No se puede guardar el archivo. Error " + e.getMessage());
        }

    }

    @Override
    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if(resource.exists() || resource.isReadable()){
                return resource;
            }else{
                throw new RuntimeException("No se puede leer el archivo ");
            }

        }catch (MalformedURLException e){
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());

    }

    @Override
    public Stream<Path> loadAll() {
        try{
            return Files.walk(this.root,1).filter(path -> !path.equals(this.root))
                    .map(this.root::relativize);
        }catch (RuntimeException | IOException e){
            throw new RuntimeException("No se pueden cargar los archivos ");
        }
    }

    @Override
    public String deleteFile(String filename) {
        try {
            Boolean delete = Files.deleteIfExists(this.root.resolve(filename));
            return "Borrado";
        }catch (IOException e){
            e.printStackTrace();
            return "Error Borrando ";
        }
    }



    public ARCHIVO create(ARCHIVO archivo) {
        //log.info("Saving new archivo:{}",archivo.getId());
        return archivoRepo.save(archivo);
    }


    public Collection<ARCHIVO> list(int limit) {
        log.info("Fetching all archivo");
        return archivoRepo.findAll(PageRequest.of(0,limit)).toList();
    }


    public ARCHIVO get(Long id) {
        log.info("Fetching archivo by id: {}",id);
        return archivoRepo.findById(id).get();
    }

    public Boolean delete(Long id) {
        log.info("Deleting archivo by ID:{}", id);
        archivoRepo.deleteById(id);
        return TRUE;
    }

    public Collection<ARCHIVO> list(Long limit) {
        return archivoRepo.ByDocumentoId(limit);
    }

}

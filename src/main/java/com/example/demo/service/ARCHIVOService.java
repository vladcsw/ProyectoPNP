package com.example.demo.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface ARCHIVOService {
    public void init();
    public void save(MultipartFile file, String fecha);
    public Resource load(String filename);
    public void deleteAll();
    public Stream<Path> loadAll();
    public String deleteFile(String filename);

}

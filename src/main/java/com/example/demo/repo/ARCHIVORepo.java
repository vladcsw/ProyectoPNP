package com.example.demo.repo;

import com.example.demo.model.ARCHIVO;
import com.example.demo.model.DOCUMENTO_TELEFONO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ARCHIVORepo extends JpaRepository<ARCHIVO,Long> {
    @Query("select op from ARCHIVO op where op.documento_id = ?1")
    List<ARCHIVO> ByDocumentoId(Long documento_id);
}

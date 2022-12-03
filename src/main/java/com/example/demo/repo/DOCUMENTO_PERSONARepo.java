package com.example.demo.repo;

import com.example.demo.model.DOCUMENTO_DETALLE;
import com.example.demo.model.DOCUMENTO_INMUEBLE;
import com.example.demo.model.DOCUMENTO_PERSONA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DOCUMENTO_PERSONARepo extends JpaRepository<DOCUMENTO_PERSONA, Long> {
    @Query("select op from DOCUMENTO_PERSONA op where op.documento_id = ?1")
    List<DOCUMENTO_PERSONA> ByDocumentoId(Long documento_id);
}

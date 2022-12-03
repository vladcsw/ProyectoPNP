package com.example.demo.repo;

import com.example.demo.model.DOCUMENTO_DETALLE;
import com.example.demo.model.DOCUMENTO_EMPRESA;
import com.example.demo.model.DOCUMENTO_INMUEBLE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DOCUMENTO_EMPRESARepo extends JpaRepository<DOCUMENTO_EMPRESA, Long> {

    @Query("select op from DOCUMENTO_EMPRESA op where op.documento_id = ?1")
    List<DOCUMENTO_EMPRESA> ByDocumentoId(Long documento_id);
}

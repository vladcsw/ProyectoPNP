package com.example.demo.repo;
import com.example.demo.model.DOCUMENTO_MODALIDAD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DOCUMENTO_MODALIDADRepo extends JpaRepository<DOCUMENTO_MODALIDAD,Long> {

    @Query("select op from DOCUMENTO_MODALIDAD op where op.documento_id = ?1")
    List<DOCUMENTO_MODALIDAD> ByDocumentoId(Long documento_id);
}
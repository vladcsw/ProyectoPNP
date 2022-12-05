package com.example.demo.repo;
import com.example.demo.model.DOCUMENTO_AGENDA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DOCUMENTO_AGENDARepo extends JpaRepository<DOCUMENTO_AGENDA,Long> {

    @Query("select op from DOCUMENTO_AGENDA op where op.documento_id = ?1")
    List<DOCUMENTO_AGENDA> ByDocumentoId(Long documento_id);
}
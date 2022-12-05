package com.example.demo.repo;
import com.example.demo.model.DOCUMENTO_CUENTA_BANCARIA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DOCUMENTO_CUENTA_BANCARIARepo extends JpaRepository<DOCUMENTO_CUENTA_BANCARIA,Long> {

    @Query("select op from DOCUMENTO_CUENTA_BANCARIA op where op.documento_id = ?1")
    List<DOCUMENTO_CUENTA_BANCARIA> ByDocumentoId(Long documento_id);
}
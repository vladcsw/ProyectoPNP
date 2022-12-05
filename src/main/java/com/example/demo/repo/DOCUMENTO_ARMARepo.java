package com.example.demo.repo;
import com.example.demo.model.DOCUMENTO_ARMA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DOCUMENTO_ARMARepo extends JpaRepository<DOCUMENTO_ARMA,Long> {

    @Query("select op from DOCUMENTO_ARMA op where op.documento_id = ?1")
    List<DOCUMENTO_ARMA> ByDocumentoId(Long documento_id);
}
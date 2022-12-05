package com.example.demo.repo;
import com.example.demo.model.DOCUMENTO_INSUMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DOCUMENTO_INSUMORepo extends JpaRepository<DOCUMENTO_INSUMO,Long> {

    @Query("select op from DOCUMENTO_INSUMO op where op.documento_id = ?1")
    List<DOCUMENTO_INSUMO> ByDocumentoId(Long documento_id);
}
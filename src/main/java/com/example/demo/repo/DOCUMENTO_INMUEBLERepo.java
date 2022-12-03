package com.example.demo.repo;
import com.example.demo.model.DOCUMENTO_INMUEBLE;
import com.example.demo.model.DOCUMENTO_VEHICULO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DOCUMENTO_INMUEBLERepo extends JpaRepository<DOCUMENTO_INMUEBLE,Long> {

    @Query("select op from DOCUMENTO_INMUEBLE op where op.documento_id = ?1")
    List<DOCUMENTO_INMUEBLE> ByDocumentoId(Long documento_id);
}

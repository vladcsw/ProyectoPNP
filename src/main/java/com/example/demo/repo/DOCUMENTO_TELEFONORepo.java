package com.example.demo.repo;
import com.example.demo.model.DOCUMENTO_INMUEBLE;
import com.example.demo.model.DOCUMENTO_TELEFONO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DOCUMENTO_TELEFONORepo extends JpaRepository<DOCUMENTO_TELEFONO,Long> {
    @Query("select op from DOCUMENTO_TELEFONO op where op.documento_id = ?1")
    List<DOCUMENTO_TELEFONO> ByDocumentoId(Long documento_id);
}

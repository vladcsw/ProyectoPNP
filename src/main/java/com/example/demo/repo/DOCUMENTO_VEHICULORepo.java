package com.example.demo.repo;
import com.example.demo.model.DOCUMENTO_INMUEBLE;
import com.example.demo.model.DOCUMENTO_VEHICULO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DOCUMENTO_VEHICULORepo extends JpaRepository<DOCUMENTO_VEHICULO,Long> {
    @Query("select op from DOCUMENTO_VEHICULO op where op.documento_id = ?1")
    List<DOCUMENTO_VEHICULO> ByDocumentoId(Long documento_id);
}

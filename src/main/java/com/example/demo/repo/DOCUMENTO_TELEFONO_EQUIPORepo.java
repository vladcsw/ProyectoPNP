package com.example.demo.repo;
import com.example.demo.model.DOCUMENTO_TELEFONO_EQUIPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DOCUMENTO_TELEFONO_EQUIPORepo extends JpaRepository<DOCUMENTO_TELEFONO_EQUIPO,Long> {

    @Query("select op from DOCUMENTO_TELEFONO_EQUIPO op where op.documento_id = ?1")
    List<DOCUMENTO_TELEFONO_EQUIPO> ByDocumentoId(Long documento_id);
}
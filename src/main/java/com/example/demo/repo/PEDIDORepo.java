package com.example.demo.repo;

import com.example.demo.model.DOCUMENTO_EMPRESA;
import com.example.demo.model.PEDIDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PEDIDORepo extends JpaRepository<PEDIDO, Long> {
    @Query("select op from PEDIDO op where op.documento_id = ?1 order by id")
    List<PEDIDO> ByDocumentoId(Long documento_id);

    @Query("select distinct p.documento_id from PEDIDO p, DOCUMENTO d where d.disposicion = 1 and p.documento_id = d.id order by p.documento_id")
    List<Long> getPedidos();
}

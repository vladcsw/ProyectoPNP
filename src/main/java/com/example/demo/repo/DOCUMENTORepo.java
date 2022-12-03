package com.example.demo.repo;

import com.example.demo.model.DOCUMENTO;
import com.example.demo.model.DOCUMENTO_VEHICULO;
import com.example.demo.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface DOCUMENTORepo extends JpaRepository<DOCUMENTO, Long> {
    @Modifying
    @Query("update DOCUMENTO op set op.disposicion = 2 where op.id = ?1")
    void papelera(Long documento_id);

    Collection<DOCUMENTO> findAllBydisposicion(int disposicion);
}

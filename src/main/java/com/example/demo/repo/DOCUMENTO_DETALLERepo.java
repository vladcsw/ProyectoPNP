package com.example.demo.repo;

import com.example.demo.model.DOCUMENTO;
import com.example.demo.model.DOCUMENTO_DETALLE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DOCUMENTO_DETALLERepo extends JpaRepository<DOCUMENTO_DETALLE, Long> {

}

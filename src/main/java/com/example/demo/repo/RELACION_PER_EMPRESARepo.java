package com.example.demo.repo;

import com.example.demo.model.DOCUMENTO_DETALLE;
import com.example.demo.model.RELACION_PER_EMPRESA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RELACION_PER_EMPRESARepo extends JpaRepository<RELACION_PER_EMPRESA, Long> {

}

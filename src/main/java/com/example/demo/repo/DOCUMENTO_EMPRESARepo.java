package com.example.demo.repo;

import com.example.demo.model.DOCUMENTO_DETALLE;
import com.example.demo.model.DOCUMENTO_EMPRESA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DOCUMENTO_EMPRESARepo extends JpaRepository<DOCUMENTO_EMPRESA, Long> {

}

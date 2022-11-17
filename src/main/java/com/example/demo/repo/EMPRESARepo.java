package com.example.demo.repo;

import com.example.demo.model.DOCUMENTO_DETALLE;
import com.example.demo.model.EMPRESA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EMPRESARepo extends JpaRepository<EMPRESA, Long> {

}

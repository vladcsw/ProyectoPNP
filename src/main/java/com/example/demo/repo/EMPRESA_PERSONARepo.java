package com.example.demo.repo;

import com.example.demo.model.DOCUMENTO_DETALLE;
import com.example.demo.model.EMPRESA_PERSONA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EMPRESA_PERSONARepo extends JpaRepository<EMPRESA_PERSONA, Long> {

}

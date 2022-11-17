package com.example.demo.repo;

import com.example.demo.model.DOCUMENTO_DETALLE;
import com.example.demo.model.DOCUMENTO_PERSONA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DOCUMENTO_PERSONARepo extends JpaRepository<DOCUMENTO_PERSONA, Long> {

}

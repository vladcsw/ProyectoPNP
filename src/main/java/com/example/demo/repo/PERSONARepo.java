package com.example.demo.repo;

import com.example.demo.model.DOCUMENTO_DETALLE;
import com.example.demo.model.PERSONA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PERSONARepo extends JpaRepository<PERSONA, Long> {

}

package com.example.demo.repo;

import com.example.demo.model.DOCUMENTO_DETALLE;
import com.example.demo.model.DOMICILIO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DOMICILIORepo extends JpaRepository<DOMICILIO, Long> {

}

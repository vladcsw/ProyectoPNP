package com.example.demo.repo;

import com.example.demo.model.PEDIDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PEDIDORepo extends JpaRepository<PEDIDO, Long> {
}

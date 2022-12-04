package com.example.demo.repo;

import com.example.demo.model.VEHICULO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VEHICULORepo extends JpaRepository<VEHICULO,Long> {
}
package com.example.demo.repo;

import com.example.demo.model.INMUEBLE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INMUEBLERepo extends JpaRepository<INMUEBLE,Long> {
}
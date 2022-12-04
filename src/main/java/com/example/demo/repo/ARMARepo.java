package com.example.demo.repo;

import com.example.demo.model.ARMA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ARMARepo extends JpaRepository<ARMA,Long> {
}
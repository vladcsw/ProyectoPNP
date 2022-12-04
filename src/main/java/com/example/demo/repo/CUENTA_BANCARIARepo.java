package com.example.demo.repo;

import com.example.demo.model.CUENTA_BANCARIA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CUENTA_BANCARIARepo extends JpaRepository<CUENTA_BANCARIA,Long> {
}
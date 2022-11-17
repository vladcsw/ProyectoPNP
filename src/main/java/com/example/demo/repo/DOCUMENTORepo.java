package com.example.demo.repo;

import com.example.demo.model.DOCUMENTO;
import com.example.demo.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DOCUMENTORepo extends JpaRepository<DOCUMENTO, Long> {

}

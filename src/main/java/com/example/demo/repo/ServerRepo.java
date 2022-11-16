package com.example.demo.repo;

import com.example.demo.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

public interface ServerRepo extends JpaRepository<Server, Long> {

    @Procedure("total_students")
    String total();
}

package com.example.demo.repo;
import com.example.demo.model.DOCUMENTO_ORGANO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DOCUMENTO_ORGANORepo extends JpaRepository<DOCUMENTO_ORGANO,Long> {

}
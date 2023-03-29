package com.crud.empleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.empleados.entity.Departamento;

@Repository
public interface DepartamentoRepositorio extends JpaRepository <Departamento, Long> {
    
}

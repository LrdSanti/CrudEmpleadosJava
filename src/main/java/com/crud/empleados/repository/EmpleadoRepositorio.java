package com.crud.empleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.empleados.entity.Empleado;

@Repository
public interface EmpleadoRepositorio extends JpaRepository <Empleado, Long> {
    
}

package com.crud.empleados.service;

import java.util.List;

import com.crud.empleados.entity.Departamento;

public interface DepartamentoServicio {
    
    public List<Departamento> listarDepartamentos();

    public Departamento guardarDepartamento(Departamento departamento);

    public Departamento obtenerDepartamento(Long id);

    public Departamento modificarDepartamento(Departamento departamento);

    public void eliminarDepartamento(Long id);
}

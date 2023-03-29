package com.crud.empleados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.empleados.entity.Departamento;
import com.crud.empleados.repository.DepartamentoRepositorio;

@Service
public class DepartamentoServicioImpl implements DepartamentoServicio {

    @Autowired
    DepartamentoRepositorio repositorio;

    @Override
    public List<Departamento> listarDepartamentos() {
        return repositorio.findAll();
    }

    @Override
    public Departamento guardarDepartamento(Departamento departamento) {
        return repositorio.save(departamento);
    }

    @Override
    public Departamento obtenerDepartamento(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Departamento modificarDepartamento(Departamento departamento) {
        return repositorio.save(departamento);
    }

    @Override
    public void eliminarDepartamento(Long id) {
        repositorio.deleteById(id);
    }

}

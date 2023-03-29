package com.crud.empleados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.empleados.entity.Empleado;
import com.crud.empleados.repository.EmpleadoRepositorio;

@Service
public class EmpleadoServicioImpl implements EmpleadoServicio {


    @Autowired
    EmpleadoRepositorio repositorio;

    @Override
    public List<Empleado> listarEmpleados() {
        // TODO Auto-generated method stub
        return repositorio.findAll();
    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        return repositorio.save(empleado);
    }

    @Override
    public Empleado obtenerEmpleadoPorId(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Empleado modificarEmpleado(Empleado empleado) {
        return repositorio.save(empleado);
    }

    @Override
    public void eliminarEmpleado(Long id) {
        repositorio.deleteById(id);
    }
    
}

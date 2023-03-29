package com.crud.empleados.service;

import java.util.List;

import com.crud.empleados.entity.Empleado;

public interface EmpleadoServicio {
    
    public List<Empleado> listarEmpleados();

    public Empleado guardarEmpleado(Empleado empleado);

    public Empleado obtenerEmpleadoPorId(Long id);

    public Empleado modificarEmpleado(Empleado empleado);

    public void eliminarEmpleado(Long id);
    
}

package com.crud.empleados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.crud.empleados.entity.Empleado;
import com.crud.empleados.service.DepartamentoServicio;
import com.crud.empleados.service.EmpleadoServicio;

@Controller
public class EmpleadoController {

    @Autowired
    private EmpleadoServicio servicio;

    @Autowired
    private DepartamentoServicio servicioDep;

    @GetMapping({ "/empleados", "/" })
    public String listarEmpleados(Model modelo) {

        Empleado empleado = new Empleado("Santiago");
        modelo.addAttribute("empleado", empleado);

        modelo.addAttribute("empleados", servicio.listarEmpleados());

        modelo.addAttribute("departamentos", servicioDep.listarDepartamentos());

        return "empleados";

    }

    @GetMapping("/empleados/nuevo")
    public String mostrarFormularioDeRegistroEmpleado(Model modelo) {

        Empleado empleado = new Empleado();

        modelo.addAttribute("empleado", empleado);
        modelo.addAttribute("departamentos", servicioDep.listarDepartamentos());
        return "registrar_empleado";

    }

    @PostMapping("/empleados")
    public String guardarEmpleado(@ModelAttribute("empleado") Empleado empleado) {

        servicio.guardarEmpleado(empleado);
        return "redirect:/empleados";
    }

    @GetMapping("/empleados/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {

        modelo.addAttribute("empleado", servicio.obtenerEmpleadoPorId(id));
        modelo.addAttribute("departamentos", servicioDep.listarDepartamentos());
        return "editar_empleados";
    }

    @PostMapping("/empleados/{id}")
    public String actualizarEmpleado(@PathVariable Long id, @ModelAttribute("empleado") Empleado empleado,
            Model modelo) {

        Empleado empleadoExistente = servicio.obtenerEmpleadoPorId(id);
        empleadoExistente.setId(id);
        empleadoExistente.setNif(empleado.getNif());
        empleadoExistente.setNombre(empleado.getNombre());
        empleadoExistente.setApellido1(empleado.getApellido1());
        empleadoExistente.setApellido2(empleado.getApellido2());
        empleadoExistente.setDepartamento(empleado.getDepartamento());
        servicio.modificarEmpleado(empleadoExistente);

        return "redirect:/empleados";
    }
    
    @GetMapping("/empleados/{id}")
    public String eliminarEmpleado(@PathVariable Long id) {
        servicio.eliminarEmpleado(id);

        return "redirect:/empleados";
    }

}

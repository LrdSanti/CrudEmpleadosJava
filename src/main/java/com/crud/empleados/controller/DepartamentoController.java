package com.crud.empleados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.crud.empleados.entity.Departamento;
import com.crud.empleados.service.DepartamentoServicio;

@Controller
public class DepartamentoController {
    

    @Autowired
    private DepartamentoServicio servicio;

    @GetMapping({"/departamentos/nuevo", "/"})
    public String mostrarFormularioDeRegistroDepartamentos(Model modelo) {

        Departamento departamento = new Departamento();

        modelo.addAttribute("departamento", departamento);

        return "registrar_departamentos";

    }
    
    @PostMapping("/departamentos")
    public String guardarDepartamento(@ModelAttribute("departamento") Departamento departamento) {

        servicio.guardarDepartamento(departamento);
        return "redirect:/empleados";
    }


    @GetMapping("/departamentos/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {

        modelo.addAttribute("departamento", servicio.obtenerDepartamento(id));

        return "editar_departamentos";
    }
    
    @PostMapping("/departamentos/{id}")
    public String actualizarDepartamento(@PathVariable Long id,
            @ModelAttribute("departamento") Departamento departamento, Model modelo) {

        Departamento departamentoExistente = servicio.obtenerDepartamento(id);

        departamentoExistente.setNombre(departamento.getNombre());
        departamentoExistente.setPresupuesto(departamentoExistente.getPresupuesto());
        departamentoExistente.setGastos(departamento.getGastos());

        servicio.modificarDepartamento(departamentoExistente);

        return "redirect:/empleados";
    }
    
    @GetMapping("/departamentos/{id}")
    public String eliminarDepartamento(@PathVariable Long id) {
        servicio.eliminarDepartamento(id);

        return "redirect:/empleados";
    }
}

package com.crud.empleados.entity;



import jakarta.persistence.*;

@Entity
@Table(name = "empleados")
public class Empleado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nif", nullable = false, length = 9)
    private String nif;
    
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    
    @Column(name = "apellido1", nullable = false, length = 100)
    private String apellido1;
    
    @Column(name = "apellido2", nullable = true, length = 100)
    private String apellido2;

    
    @ManyToOne
    private Departamento departamento;

    public Empleado() {
    }
    

    public Empleado(long id, String nif, String nombre, String apellido1, String apellido2) {
        this.id = id;
        this.nif = nif;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    public Empleado(String nombre) {
        this.nombre = nombre;

    }
    
    


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getNif() {
        return nif;
    }


    public void setNif(String nif) {
        this.nif = nif;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellido1() {
        return apellido1;
    }


    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }


    public String getApellido2() {
        return apellido2;
    }


    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }


    public Departamento getDepartamento() {
        return departamento;
    }


    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }


    

}

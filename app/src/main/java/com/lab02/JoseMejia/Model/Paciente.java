package com.lab02.JoseMejia.Model;

import java.io.Serializable;

public class Paciente implements Serializable {
    private String nombre;
    private String dni;
    private String direccion;

    public Paciente(String nombre, String dni, String direccion){
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
    }
    public Paciente() {
        this.nombre = null;
        this.dni = null;
        this.direccion = null;
    }
    //getters
    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getDireccion() {
        return direccion;
    }
    //setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}

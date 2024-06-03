/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author ramir
 */
public class Entrenador {
     private int idEntrenador;
    private char dni;
    private char nombre;
    private char apellido;
    private char especialidad;
    private boolean estado;

    public Entrenador(int idEntrenador, char dni, char nombre, char apellido, char especialidad, boolean estado) {
        this.idEntrenador = idEntrenador;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.estado = estado;
    }

    public int getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(int idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public char getDni() {
        return dni;
    }

    public void setDni(char dni) {
        this.dni = dni;
    }

    public char getNombre() {
        return nombre;
    }

    public void setNombre(char nombre) {
        this.nombre = nombre;
    }

    public char getApellido() {
        return apellido;
    }

    public void setApellido(char apellido) {
        this.apellido = apellido;
    }

    public char getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(char especialidad) {
        this.especialidad = especialidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}

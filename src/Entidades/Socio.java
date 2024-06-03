/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author ramir
 */
public class Socio {
    private int idSocio;
    private char dni;
    private char nombre;
    private char apellido;
    private int edad;
    private char correo;
    private char telefono;
    private boolean estado;

    public Socio(int idSocio, char dni, char nombre, char apellido, int edad, char correo, char telefono, boolean estado) {
        this.idSocio = idSocio;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
        this.estado = estado;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getCorreo() {
        return correo;
    }

    public void setCorreo(char correo) {
        this.correo = correo;
    }

    public char getTelefono() {
        return telefono;
    }

    public void setTelefono(char telefono) {
        this.telefono = telefono;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}

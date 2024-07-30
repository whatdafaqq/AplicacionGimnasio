/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.time.LocalDate;



/**
 *
 * @author ramir
 */
public class Membresia {
    private int idMembresia;
    private Socio socio;
    private int cantidadPases;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double costo;
    private boolean estado;

    public Membresia() {
    }

    
    
    public Membresia(int idMembresia, Socio socio, int cantidadPases, LocalDate fechaInicio, LocalDate fechaFin, double costo, boolean estado) {
        this.idMembresia = idMembresia;
        this.socio = socio;
        this.cantidadPases = cantidadPases;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costo = costo;
        this.estado = estado;
    }

    public int getIdMembresia() {
        return idMembresia;
    }

    public void setIdMembresia(int idMembresia) {
        this.idMembresia = idMembresia;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public int getCantidadPases() {
        return cantidadPases;
    }

    public void setCantidadPases(int cantidadPases) {
        this.cantidadPases = cantidadPases;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Membresia{" + "idMembresia=" + idMembresia + ", socio=" + socio + ", cantidadPases=" + cantidadPases + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", costo=" + costo + ", estado=" + estado + '}';
    }

   
    
}

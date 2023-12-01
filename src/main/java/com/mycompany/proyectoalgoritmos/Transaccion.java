/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoalgoritmos;

/**
 *
 * @author Be
 */
import java.util.Date;

public class Transaccion {
    private Date fecha;
    private int cantidad;
    private String observaciones;
    private String nombreProducto;

    public Transaccion(Date fecha, int cantidad, String observaciones, String nombreProducto) {
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.observaciones = observaciones;
        this.nombreProducto = nombreProducto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }


}

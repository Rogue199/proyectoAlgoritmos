/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoalgoritmos;

/**
 *
 * @author Be
 */
public class Pedidos implements Comparable<Pedidos>{
    String cliente;
    String nombre;
    String producto;
    int cantidad;

    public Pedidos(String cliente, String nombre, String producto, int cantidad) {
        this.cliente = cliente;
        this.nombre = nombre;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public String getCliente() {
        return cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    public int compareTo(Pedidos otro) {
            return this.getNombre().compareTo(otro.getNombre());
        }
}

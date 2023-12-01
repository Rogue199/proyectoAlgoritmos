/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoalgoritmos;

/**
 *
 * @author rober
 */
import java.util.*;

public class Main {
    private static List<Producto> productos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Agregar producto");
            System.out.println("2. Ordenar productos por ID");
            System.out.println("3. Buscar producto por ID");
          System.out.println("4. Consulta general");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    ordenarProductos();
                    break;
                case 3:
                    buscarProducto();
                    break;
                  case 4:
                    consultaGeneral();
                    break;
                case 5:
                    System.exit(0);
                    
            }
        }
    }

    private static void agregarProducto() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID: ");
        int id = scanner.nextInt();
        System.out.print("Nombre: ");
        String nombre = scanner.next();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();
        productos.add(new Producto(id, nombre, precio, cantidad));
    }

    private static void ordenarProductos() {
        productos.sort(Comparator.comparing(Producto::getId));
    }

    private static void buscarProducto() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID del producto a buscar: ");
        int id = scanner.nextInt();
        int index = Collections.binarySearch(productos, new Producto(id, "", 0, 0), Comparator.comparing(Producto::getId));
        if (index >= 0) {
            Producto producto = productos.get(index);
            System.out.println("Producto encontrado: " + producto.getNombre());
        } else {
            System.out.println("Producto no encontrado");
        }
    }
     private static void consultaGeneral() {
        for (Producto producto : productos) {
            System.out.println("ID: " + producto.getId());
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Cantidad: " + producto.getCantidad());
            System.out.println("--------------------");
        }
    }
}


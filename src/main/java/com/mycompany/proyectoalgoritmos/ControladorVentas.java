/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoalgoritmos;

import static com.mycompany.proyectoalgoritmos.QuickSort.quicksort;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Be
 */
public class ControladorVentas {
    private static List<Producto> productos;
    private Stack<Transaccion> transacciones;
    List<Pedidos> copiaCola;
    private Queue<Pedidos> colaPedidos;
    DefaultTableModel modelo;
    DefaultTableModel modelo2;
    DefaultTableModel modelo3;
    JTable tabla;
    public ControladorVentas(){
        productos = productos = new ArrayList<>();
        this.modelo = modelo;
        transacciones = new Stack<>();
        colaPedidos = new LinkedList<>();
    }
    
      public void agregarProducto(int id,String nombre,double precio,int cantidad) {
        productos.add(new Producto(id, nombre, precio, cantidad));
        actualizarTabla();
    }
      
      public void actualizarTabla() {
        modelo.setRowCount(0);

        for (Producto producto : productos) {
            Object[] fila = {producto.getId(), producto.getNombre(), producto.getPrecio(), producto.getCantidad()};
            modelo.addRow(fila);
        }
    }
      
      public void buscarProducto(int clave) {
        quicksort(productos);
        int index = Collections.binarySearch(productos, new Producto(clave, "", 0, 0), Comparator.comparing(Producto::getId));
        if (index >= 0) {
           modelo.setRowCount(0);
           Object[] fila = {productos.get(index).getId(), productos.get(index).getNombre(), productos.get(index).getPrecio(), productos.get(index).getCantidad()};
            modelo.addRow(fila);
        } else {
             modelo.setRowCount(0);
        }
    }
      
      public void agregarTransaccion(Date fecha, int cantidad, String observaciones, String nombreProducto) {
        Transaccion transaccion = new Transaccion(fecha, cantidad, observaciones, nombreProducto);
        transacciones.push(transaccion);
    
    actualizarTablaTransacciones();
}

      
      
      public void ordenarYFiltrar(String filtro) {
        List<Producto> productosFiltrados = new ArrayList<>();

        for (Producto producto : productos) {
            if (producto.getNombre().toLowerCase().contains(filtro.toLowerCase())) {
                productosFiltrados.add(producto);
            }
        }
        quicksort(productosFiltrados);
        modelo.setRowCount(0);
        for (Producto producto : productosFiltrados) {
            Object[] fila = {producto.getId(), producto.getNombre(), producto.getPrecio(), producto.getCantidad()};
            modelo.addRow(fila);
        }
    } 
      
        public Producto obtenerProductoSeleccionado(int filaSeleccionada) {
            if (filaSeleccionada >= 0 && filaSeleccionada < productos.size()) {
                return productos.get(filaSeleccionada);
            }
            return null;
        }
        
        public void actualizarTablaTransacciones() {
    modelo2.setRowCount(0);

    for (Transaccion transaccion : transacciones) {
        Object[] fila = {
                transaccion.getFecha(),
                transaccion.getCantidad(),
                transaccion.getObservaciones(),
                transaccion.getNombreProducto()
        };
        modelo2.addRow(fila);
    }
}
public void eliminarUltimaTransaccion() {
    if (!transacciones.isEmpty()) {
        transacciones.pop();
    }
    actualizarTablaTransacciones();
}

public void hacerDiezPedidos() {
        for (int i = 1; i <= 10; i++) {
            String cliente = "Cliente" + i;
            String nombre = "Nombre" + (i*3-2);
            String producto = "Producto" + i;
            int cantidad = i * 2;

            Pedidos pedido = new Pedidos(cliente, nombre, producto, cantidad);

            colaPedidos.offer(pedido);
        }

        mostrarPedidosEnTabla();
    }

    private void mostrarPedidosEnTabla() {
        modelo3.setRowCount(0);
        for (Pedidos pedido : colaPedidos) {
            Object[] fila = {
                    pedido.getCliente(),
                    pedido.getNombre(),
                    pedido.getProducto(),
                    pedido.getCantidad()
            };
            modelo3.addRow(fila);
        }
    }
    
    public void eliminarUltimoPedido() {
    if (!colaPedidos.isEmpty()) {
        int filaEliminada = modelo3.getRowCount() - 1;

        colaPedidos.poll();


        mostrarPedidosEnTabla(filaEliminada);
    }
}

public void mostrarPedidosEnTabla(int filaDestacada) {
    CustomRenderer customRenderer = new CustomRenderer(filaDestacada);
    tabla.setDefaultRenderer(Object.class, customRenderer);  
    tabla.setModel(modelo3);
}



    public void ordenarColaPedidos() {
        List<Pedidos> listaPedidos = new ArrayList<>(colaPedidos);
        Insercion.insercion(listaPedidos);
        mostrarPedidosOrdenados(listaPedidos);
    }

    private void mostrarPedidosOrdenados(List<Pedidos>colaPedidos) {
        modelo3.setRowCount(0);
        for (Pedidos pedido : colaPedidos) {
            Object[] fila = {
                    pedido.getCliente(),
                    pedido.getNombre(),
                    pedido.getProducto(),
                    pedido.getCantidad()
            };
            modelo3.addRow(fila);
        }
    }
    




      public List<Producto> getProductos(){
           return productos;
      }
      
      public void setModelo(DefaultTableModel modelo){
          this.modelo = modelo;
      }
      
      public void setModelo2(DefaultTableModel modelo2){
          this.modelo2 = modelo2;
      }
     
      public void setModelo3(DefaultTableModel modelo3){
          this.modelo3 = modelo3;
      }
      
      public void setTabla(JTable tabla){
          this.tabla = tabla;
      }
      

}

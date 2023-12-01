/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoalgoritmos;

import java.util.List;

/**
 *
 * @author Be
 */
public class Insercion {

    public static <E extends Comparable<E>> void insercion(List<E> lista) {
        for (int i = 1; i < lista.size(); i++) {
            E aux = lista.get(i);
            int j = i - 1;

            while (j >= 0 && aux.compareTo(lista.get(j)) < 0) {
                lista.set(j + 1, lista.get(j));
                j--;
            }

            lista.set(j + 1, aux);
        }
    }
}

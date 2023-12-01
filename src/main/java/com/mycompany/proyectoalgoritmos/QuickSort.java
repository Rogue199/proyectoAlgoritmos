    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoalgoritmos;


import java.util.List;

public class QuickSort {

    public static <E extends Comparable<E>> void quicksort(List<E> lista, int primero, int ultimo) {
        int central = (primero + ultimo) / 2;
        E pivote = lista.get(central);
        int i = primero;
        int j = ultimo;

        do {
            while (lista.get(i).compareTo(pivote) < 0) i++;
            while (lista.get(j).compareTo(pivote) > 0) j--;

            if (i <= j) {
                E aux = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, aux);
                i++;
                j--;
            }
        } while (i <= j);

        if (primero < j)
            quicksort(lista, primero, j);
        if (i < ultimo)
            quicksort(lista, i, ultimo);
    }

    public static <E extends Comparable<E>> void quicksort(List<E> lista) {
        if (lista == null || lista.size() <= 1) {
            return;
        }
        quicksort(lista, 0, lista.size() - 1);
    }

}

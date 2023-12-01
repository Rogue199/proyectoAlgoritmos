/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoalgoritmos;

/**
 *
 * @author Be
 */
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Component;

public class CustomRenderer extends DefaultTableCellRenderer {
    private int filaDestacada;

    public CustomRenderer(int filaDestacada) {
        this.filaDestacada = filaDestacada;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (row == filaDestacada) {
            c.setBackground(Color.GREEN);
        } else {
            c.setBackground(table.getBackground());
        }

        return c;
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author rodrigo
 */
public class ListClases extends javax.swing.JInternalFrame {

    private JTable table;

    public ListClases() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Lista de Clases Disponibles");
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        // Columnas de la tabla
        String[] columns = {"Nombre", "Entrenador", "Horario"};

        // Datos de ejemplo (se deberían obtener de la base de datos)
        Object[][] data = {
            {"Yoga", "Juan Pérez", "Lunes y Miércoles 18:00-19:00"},
            {"CrossFit", "María Gómez", "Martes y Jueves 17:00-18:00"},
            {"Pilates", "Carlos Rodríguez", "Viernes 19:00-20:00"}
        };

        table = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(table);

        getContentPane().add(scrollPane, BorderLayout.CENTER);

        pack();
        setLocation(50, 50); // Posición inicial dentro del JDesktopPane
    }

    public static void main(String[] args) {
        // Crear un marco para demostrar la funcionalidad de JInternalFrame
        JFrame frame = new JFrame("Demo de JInternalFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JDesktopPane desktopPane = new JDesktopPane();
        frame.add(desktopPane);

        ListClases listClasesFrame = new ListClases();
        desktopPane.add(listClasesFrame);
        listClasesFrame.setVisible(true);

        frame.setVisible(true);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setTitle("Lista De Clases");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables


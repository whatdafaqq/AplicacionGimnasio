/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuscarClase extends javax.swing.JInternalFrame {

    private JTextField txtNombreClase;
    private JTextField txtEntrenador;
    private JTextField txtHorario;
    private JButton btnBuscar;

    public BuscarClase() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Buscar Clase");
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        JLabel lblNombreClase = new JLabel("Nombre de la Clase:");
        txtNombreClase = new JTextField();

        JLabel lblEntrenador = new JLabel("Entrenador:");
        txtEntrenador = new JTextField();

        JLabel lblHorario = new JLabel("Horario:");
        txtHorario = new JTextField();

        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para buscar clase
                String nombreClase = txtNombreClase.getText();
                String entrenador = txtEntrenador.getText();
                String horario = txtHorario.getText();
                JOptionPane.showMessageDialog(BuscarClase.this, "Buscar:\nNombre: " + nombreClase + "\nEntrenador: " + entrenador + "\nHorario: " + horario);
            }
        });

        panel.add(lblNombreClase);
        panel.add(txtNombreClase);
        panel.add(lblEntrenador);
        panel.add(txtEntrenador);
        panel.add(lblHorario);
        panel.add(txtHorario);
        panel.add(new JLabel());  // Filler to align the button
        panel.add(btnBuscar);

        getContentPane().add(panel, BorderLayout.CENTER);

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

        BuscarClase buscarClaseFrame = new BuscarClase();
        desktopPane.add(buscarClaseFrame);
        buscarClaseFrame.setVisible(true);

        frame.setVisible(true);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setTitle("Buscar Clases");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables


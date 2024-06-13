/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarMembresia extends javax.swing.JInternalFrame {

    private JTextField txtNombreSocio;
    private JTextField txtCantidadPases;
    private JTextField txtDuracion;
    private JButton btnRegistrar;

    public RegistrarMembresia() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Registrar Nueva Membresía");
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        JLabel lblNombreSocio = new JLabel("Nombre del Socio:");
        txtNombreSocio = new JTextField();

        JLabel lblCantidadPases = new JLabel("Cantidad de Pases:");
        txtCantidadPases = new JTextField();

        JLabel lblDuracion = new JLabel("Duración (meses):");
        txtDuracion = new JTextField();

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para registrar membresía
                String nombreSocio = txtNombreSocio.getText();
                String cantidadPases = txtCantidadPases.getText();
                String duracion = txtDuracion.getText();
                JOptionPane.showMessageDialog(RegistrarMembresia.this, "Membresía registrada:\nNombre del Socio: " + nombreSocio + "\nCantidad de Pases: " + cantidadPases + "\nDuración: " + duracion + " meses");
            }
        });

        panel.add(lblNombreSocio);
        panel.add(txtNombreSocio);
        panel.add(lblCantidadPases);
        panel.add(txtCantidadPases);
        panel.add(lblDuracion);
        panel.add(txtDuracion);
        panel.add(new JLabel()); // Filler to align the button
        panel.add(btnRegistrar);

        getContentPane().add(panel, BorderLayout.CENTER);

        pack();
        setLocation(50, 50); // Posición inicial dentro del JDesktopPane
    }

    public static void main(String[] args) {
        // Crear un marco para demostrar la funcionalidad de JInternalFrame
        JFrame frame = new JFrame("Demo de JInternalFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JDesktopPane desktopPane = new JDesktopPane();
        frame.add(desktopPane);

        RegistrarMembresia registrarMembresiaFrame = new RegistrarMembresia();
        desktopPane.add(registrarMembresiaFrame);
        registrarMembresiaFrame.setVisible(true);

        frame.setVisible(true);
    }
}
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
}

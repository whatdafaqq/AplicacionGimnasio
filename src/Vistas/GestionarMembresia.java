/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
/**
 *
 * @author rodrigo
 */
public class GestionarMembresia extends javax.swing.JInternalFrame {

    private JTextField txtNombreSocio;
    private JTextField txtCantidadPases;
    private JTextField txtDuracion;
    private JButton btnActualizar;
    private JButton btnCancelar;

    public GestionarMembresia() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Gestionar Membresía");
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

        btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // Lógica para actualizar membresía
                actualizarMembresia();
            }
        });

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // Cerrar el JInternalFrame
                dispose();
            }
        });

        panel.add(lblNombreSocio);
        panel.add(txtNombreSocio);
        panel.add(lblCantidadPases);
        panel.add(txtCantidadPases);
        panel.add(lblDuracion);
        panel.add(txtDuracion);
        panel.add(btnActualizar);
        panel.add(btnCancelar);

        getContentPane().add(panel);

        pack();
        setLocation(50, 50); // Posición inicial dentro del JDesktopPane
    }

    private void actualizarMembresia() {
        // Aquí implementarías la lógica para actualizar la membresía en la base de datos
        String nombreSocio = txtNombreSocio.getText();
        String cantidadPases = txtCantidadPases.getText();
        String duracion = txtDuracion.getText();
        
        JOptionPane.showMessageDialog(this, "Membresía actualizada:\nNombre del Socio: " + nombreSocio 
                + "\nCantidad de Pases: " + cantidadPases + "\nDuración: " + duracion + " meses");
    }
}
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

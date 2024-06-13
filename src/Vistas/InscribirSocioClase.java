/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author rodrigo
 */
public class InscribirSocioClase extends javax.swing.JInternalFrame {

    private JTextField txtNombreSocio;
    private JTextField txtNombreClase;
    private JButton btnInscribir;

    public InscribirSocioClase() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Inscribir Socio en Clase");
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        JLabel lblNombreSocio = new JLabel("Nombre del Socio:");
        txtNombreSocio = new JTextField();

        JLabel lblNombreClase = new JLabel("Nombre de la Clase:");
        txtNombreClase = new JTextField();

        btnInscribir = new JButton("Inscribir");
        btnInscribir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para inscribir socio
                String nombreSocio = txtNombreSocio.getText();
                String nombreClase = txtNombreClase.getText();
                JOptionPane.showMessageDialog(InscribirSocioClase.this, "Socio inscrito:\nNombre del Socio: " + nombreSocio + "\nNombre de la Clase: " + nombreClase);
            }
        });

        panel.add(lblNombreSocio);
        panel.add(txtNombreSocio);
        panel.add(lblNombreClase);
        panel.add(txtNombreClase);
        panel.add(new JLabel()); // Espacio en blanco para alinear el botón
        panel.add(btnInscribir);

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

        InscribirSocioClase inscribirSocioClaseFrame = new InscribirSocioClase();
        desktopPane.add(inscribirSocioClaseFrame);
        inscribirSocioClaseFrame.setVisible(true);

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

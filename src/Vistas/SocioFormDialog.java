/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import Data.SocioData;
import Entidades.Socio;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SocioFormDialog extends JDialog {
    private JTextField txtDni;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtEdad;
    private JTextField txtCorreo;
    private JTextField txtTelefono;
    private JCheckBox chkEstado;
    private JButton btnSave;

    public SocioFormDialog(Frame owner) {
        super(owner, "Añadir Socio", true);
        setSize(300, 350);
        setLayout(new GridLayout(8, 2, 10, 10));
        setLocationRelativeTo(owner);

        txtDni = new JTextField(20);
        txtNombre = new JTextField(20);
        txtApellido = new JTextField(20);
        txtEdad = new JTextField(20);
        txtCorreo = new JTextField(20);
        txtTelefono = new JTextField(20);
        chkEstado = new JCheckBox("Activo");
        btnSave = new JButton("Guardar");

        add(new JLabel("DNI:"));
        add(txtDni);
        add(new JLabel("Nombre:"));
        add(txtNombre);
        add(new JLabel("Apellido:"));
        add(txtApellido);
        add(new JLabel("Edad:"));
        add(txtEdad);
        add(new JLabel("Correo:"));
        add(txtCorreo);
        add(new JLabel("Teléfono:"));
        add(txtTelefono);
        add(new JLabel("Estado:"));
        add(chkEstado);
        add(new JLabel(""));
        add(btnSave);

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí va la lógica p3ara guardar el entrenador en la base de datos
                String dni = txtDni.getText();
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                int edad = Integer.parseInt(txtEdad.getText());
                String correo = txtCorreo.getText();
                String telefono = txtTelefono.getText();
                boolean estado = chkEstado.isSelected();

                Socio socio = new Socio(0, dni, nombre, apellido, edad, correo, telefono, estado);
                SocioData sd = new SocioData();
                try {
                    sd.agregarSocio(socio);
                    JOptionPane.showMessageDialog(null, "Socio guardado exitosamente!");
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al guardar el socio: " + ex.getMessage());
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

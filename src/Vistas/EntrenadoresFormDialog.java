/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

/**
 *
 * @author ramir
 */
import Data.EntrenadorData;
import Entidades.Entrenador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class EntrenadoresFormDialog extends JDialog {
    private JTextField txtDni;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtEspecialidad;
    private JButton btnSave;

    public EntrenadoresFormDialog(Frame owner) {
        super(owner, "Añadir Entrenador", true);
        setSize(300, 200);
        setLayout(new GridLayout(5, 2, 10, 10));
        setLocationRelativeTo(owner);

        txtDni = new JTextField(20);
        txtNombre = new JTextField(20);
        txtApellido = new JTextField(20);
        txtEspecialidad = new JTextField(20);
        btnSave = new JButton("Guardar");

        add(new JLabel("Dni:"));
        add(txtDni);
        add(new JLabel("Nombre:"));
        add(txtNombre);
        add(new JLabel("Apellido:"));
        add(txtApellido);
        add(new JLabel("Especialidad:"));
        add(txtEspecialidad);
        add(new JLabel(""));
        add(btnSave);

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí va la lógica para guardar el entrenador en la base de datos
                String dni = txtDni.getText();
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                String especialidad = txtEspecialidad.getText();
                
                // Lógica para guardar en la base de datos usando JDBC
                 Entrenador entrenador = new Entrenador(0, dni, nombre, apellido, especialidad, true);
                 EntrenadorData ed = new EntrenadorData();
                try {
                    ed.agregarEntrenador(entrenador);
                    JOptionPane.showMessageDialog(null, "Entrenador guardado exitosamente!");
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al guardar el entrenador: " + ex.getMessage());
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
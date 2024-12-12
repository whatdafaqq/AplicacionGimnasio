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
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class EntrenadoresPanel extends JPanel {

    private JTextField txtSearch;
    private JButton btnSearch, btnAddEntrenador, btnListaDeEntrenadores, btnEliminarEntrenador;
    private JTable table;
    private JScrollPane scrollPane;

    public EntrenadoresPanel() {
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        txtSearch = new JTextField(20);
        btnSearch = new JButton("Buscar");
        btnAddEntrenador = new JButton("Añadir Entrenador");
        btnListaDeEntrenadores = new JButton("Lista de Entrenadores");
        btnEliminarEntrenador = new JButton("Eliminar Entrenador");

        topPanel.add(new JLabel("Buscar:"));
        topPanel.add(txtSearch);
        topPanel.add(btnSearch);
        topPanel.add(btnAddEntrenador);
        topPanel.add(btnListaDeEntrenadores);
        topPanel.add(btnEliminarEntrenador);

        add(topPanel, BorderLayout.SOUTH);
        add(btnListaDeEntrenadores, BorderLayout.NORTH);
        btnListaDeEntrenadores.setBackground(Color.red);

        // Inicializar tabla vacía
        table = new JTable(new Object[0][0], new String[]{"ID", "DNI", "Nombre", "Apellido", "Especialidad", "Estado"});
        scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Action listeners
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EntrenadorData ed = new EntrenadorData();
                busquedaPorNombre();

            }
        });

        btnAddEntrenador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EntrenadoresFormDialog(null).setVisible(true);
            }
        });

        btnListaDeEntrenadores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablaEntrenadoresCompleta();
            }
        });
        btnEliminarEntrenador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarEntrenador();
            }
        });

    }

    private void busquedaPorNombre() {
        EntrenadorData ed = new EntrenadorData();

        try {
            if (txtSearch.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "El campo de texto está vacío.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                List<Entrenador> entrenadores = ed.searchEntrenador(txtSearch.getText());
                if (entrenadores.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se encontró ningun Entrenador con ese Nombre.");
                    return;
                }
                Object[][] data = new Object[entrenadores.size()][6];
                for (int i = 0; i < entrenadores.size(); i++) {
                    Entrenador entrenador = entrenadores.get(i);
                    data[i][0] = entrenador.getIdEntrenador();
                    data[i][1] = entrenador.getDni();
                    data[i][2] = entrenador.getNombre();
                    data[i][3] = entrenador.getApellido();
                    data[i][4] = entrenador.getEspecialidad();
                    data[i][5] = entrenador.isEstado();

                }
                table.setModel(new javax.swing.table.DefaultTableModel(
                        data,
                        new String[]{"ID", "DNI", "Nombre", "Apellido", "Especialidad", "Estado"}
                ));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar entrenadores: " + ex.getMessage());
        }
    }

    void tablaEntrenadoresCompleta() {

        EntrenadorData ed = new EntrenadorData();
        List<Entrenador> entrenadores = ed.listaEntrenadores();

        String[] columnNames = {"ID", "DNI", "Nombre", "Apellido", "Especialidad", "Estado"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Entrenador entrenador : entrenadores) {
            Object[] row = new Object[7];
            row[0] = entrenador.getIdEntrenador();
            row[1] = entrenador.getDni();
            row[2] = entrenador.getNombre();
            row[3] = entrenador.getApellido();
            row[4] = entrenador.getEspecialidad();
            row[5] = entrenador.isEstado() ? "Activa" : "Inactiva";
            model.addRow(row);
        }
        table.setModel(model);
    }

    void eliminarEntrenador() {
        int selectedRow = table.getSelectedRow();

        if (selectedRow >= 0) {
            // Obtener el ID del Socio seleccionado
            int idEntrenador = (int) table.getModel().getValueAt(selectedRow, 0);

            // Confirmar la eliminación con un diálogo
            int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este Entrenador?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                // Eliminar la membresía de la base de datos
                EntrenadorData ed = new EntrenadorData();
                ed.deleteEntrenador(idEntrenador);

                // Actualizar la tabla
                tablaEntrenadoresCompleta();

            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un socio para eliminar.");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
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

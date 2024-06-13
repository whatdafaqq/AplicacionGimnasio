/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

/**
 *
 * @author ramir
 */
// En la clase ClasesPanel

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import Entidades.Clase;
import Data.ClaseData;
import javax.swing.table.DefaultTableModel;

public class ClasesPanel extends JPanel {
    private JTextField txtSearch;
    private JButton btnSearch, btnAddClase;
    private JTable table;
    private JScrollPane scrollPane;

    public ClasesPanel() {
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        txtSearch = new JTextField(20);
        btnSearch = new JButton("Buscar");
        btnAddClase = new JButton("Añadir Clase");

        topPanel.add(new JLabel("Buscar:"));
        topPanel.add(txtSearch);
        topPanel.add(btnSearch);
        topPanel.add(btnAddClase);

        add(topPanel, BorderLayout.NORTH);

        table = new JTable();
        scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTerm = txtSearch.getText();
                ClaseData cd = new ClaseData();
                List<Clase> clases = cd.buscarClases(searchTerm);
                actualizarTablaClases(clases);
            }
        });

        btnAddClase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClasesFormDialog formDialog = new ClasesFormDialog(null);
                formDialog.setVisible(true);
                // Actualizar la tabla después de añadir una nueva clase
                ClaseData cd = new ClaseData();
                List<Clase> clases = cd.listarClases();
                actualizarTablaClases(clases);
            }
        });

        // Inicializar tabla con todas las clases
        ClaseData cd = new ClaseData();
        List<Clase> clases = cd.listarClases();
        actualizarTablaClases(clases);
    }

    private void actualizarTablaClases(List<Clase> clases) {
        String[] columnNames = {"ID", "Nombre", "Entrenador", "Horario", "Capacidad", "Estado"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Clase clase : clases) {
            Object[] row = new Object[6];
            row[0] = clase.getIdClase();
            row[1] = clase.getNombre();
            row[2] = clase.getEntrenador().getNombre();
            row[3] = clase.getHorario().toString();
            row[4] = clase.getCapacidad();
            row[5] = clase.isEstado() ? "Activa" : "Inactiva";
            model.addRow(row);
        }

        table.setModel(model);
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

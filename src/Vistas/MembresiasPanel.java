/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import Data.MembresiaData;
import Entidades.Membresia;
import Vistas.MembresiaFormDialog;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ramir
 */
public class MembresiasPanel extends JPanel {
    private JTextField txtSearch;
    private JButton btnSearch, btnAddMembresia;
    private JTable table;
    private JScrollPane scrollPane;
    
    public MembresiasPanel() {
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        txtSearch = new JTextField(20);
        btnSearch = new JButton("Buscar");
        btnAddMembresia = new JButton("Añadir Membresía");

        topPanel.add(new JLabel("Buscar:"));
        topPanel.add(txtSearch);
        topPanel.add(btnSearch);
        topPanel.add(btnAddMembresia);

        add(topPanel, BorderLayout.NORTH);

        table = new JTable();
        scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTerm = txtSearch.getText();
                MembresiaData md = new MembresiaData();
                List<Membresia> membresias =  md.buscarMembresias(searchTerm);
                if (membresias.equals(searchTerm)) {
                    
                actualizarTablaMembresias(membresias);
                
                    
                }else{
                   JOptionPane.showMessageDialog(scrollPane,  "Escriba una membresia correcta.");
                }
            }
        });

        btnAddMembresia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MembresiaFormDialog formDialog = new MembresiaFormDialog(null);
                formDialog.setVisible(true);
                // Actualizar la tabla después de añadir una nueva membresía
                MembresiaData md = new MembresiaData();
                List<Membresia> membresias = md.listarMembresias();
                actualizarTablaMembresias(membresias);
                    
                
            }
        });

        // Inicializar tabla con todas las membresías
//        MembresiaData md = new MembresiaData();
//        List<Membresia> membresias = md.listarMembresias();
//        actualizarTablaMembresias(membresias);
    }

    private void actualizarTablaMembresias(List<Membresia> membresias) {
        String[] columnNames = {"ID", "Socio", "Cantidad Pases", "Fecha Inicio", "Fecha Fin", "Costo", "Estado"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Membresia membresia : membresias) {
            Object[] row = new Object[7];
            row[0] = membresia.getIdMembresia();
            row[1] = membresia.getSocio().getNombre();
            row[2] = membresia.getCantidadPases();
            row[3] = membresia.getFechaInicio().toString();
            row[4] = membresia.getFechaFin().toString();
            row[5] = membresia.getCosto();
            row[6] = membresia.isEstado() ? "Activa" : "Inactiva";
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

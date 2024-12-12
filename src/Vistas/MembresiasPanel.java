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
    private JButton btnSearch, btnAddMembresia, btnListaDeMembresias, btnDeleteMembresia;
    private JLabel jlBuscar;
    private JTable table;
    private JScrollPane scrollPane;
   
    
    public MembresiasPanel() {
        
        
        
        //Un BorderLayout para tener más control sobre la posición de los elementos
        setLayout(new BorderLayout());

        // Agregar un panel para contener los botones
        JPanel topPanel = new JPanel();
        
        jlBuscar = new JLabel("Buscar");
        btnSearch = new JButton("Buscar");
        txtSearch = new JTextField(20);
        btnAddMembresia = new JButton("Añadir Membresía");
        btnListaDeMembresias = new JButton("Listado de Membresias");
        btnDeleteMembresia = new JButton("Eliminar Membresía");

        btnListaDeMembresias.setBackground(Color.GREEN);
        
        topPanel.add(jlBuscar);
        topPanel.add(txtSearch);
        topPanel.add(btnSearch);
        topPanel.add(btnAddMembresia);
        topPanel.add(btnListaDeMembresias);
        topPanel.add(btnDeleteMembresia);

        add(btnListaDeMembresias, BorderLayout.NORTH);
        add(topPanel, BorderLayout.SOUTH);
        table = new JTable();
        scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    
                String searchTerm = txtSearch.getText();
                  MembresiaData md = new MembresiaData();
        List<Membresia> membresias = md.buscarMembresias(searchTerm);
                busquedaDeMembresiasDeSocio(membresias, searchTerm);
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
//                actualizarTablaMembresias(membresias);

            }
        });
        
        btnListaDeMembresias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MembresiaData md = new MembresiaData();
                List<Membresia> membresias = md.listarMembresias();      
                tablaMembresiasCompleta(membresias);
            }
        });
        
       btnDeleteMembresia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
              eliminarMembresia();
                
                  }
       });


    }
    

    private void busquedaDeMembresiasDeSocio(List<Membresia> membresias, String nombreSocio) {
        String[] columnNames = {"ID", "Socio", "Cantidad Pases", "Fecha Inicio", "Fecha Fin", "Costo", "Estado"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
      
        boolean encontrado = false;

        for (Membresia membresia : membresias) {
            if (membresia.getSocio().getNombre().equalsIgnoreCase(nombreSocio)) {
                
            Object[] row = new Object[7];
            row[0] = membresia.getIdMembresia();
            row[1] = membresia.getSocio().getNombre();
            row[2] = membresia.getCantidadPases();
            row[3] = membresia.getFechaInicio().toString();
            row[4] = membresia.getFechaFin().toString();
            row[5] = membresia.getCosto();
            row[6] = membresia.isEstado() ? "Activa" : "Inactiva";
            model.addRow(row);
            encontrado = true;
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró ninguna persona con ese nombre.");
        }
        table.setModel(model);
    }
    
    private void tablaMembresiasCompleta(List<Membresia> membresias) {
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

    private void eliminarMembresia(){
        int selectedRow = table.getSelectedRow();
              
              if(selectedRow >= 0){ 
                  // Obtener el ID de la membresía seleccionada
                  int idMembresia = (int) table.getModel().getValueAt(selectedRow, 0);
                  
                  // Confirmar la eliminación con un diálogo
            int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar esta membresía?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                // Eliminar la membresía de la base de datos
                MembresiaData md = new MembresiaData();
                md.eliminarMembresia(idMembresia);

                // Actualizar la tabla
                List<Membresia> membresias = md.listarMembresias();
                tablaMembresiasCompleta(membresias);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una membresía para eliminar.");
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

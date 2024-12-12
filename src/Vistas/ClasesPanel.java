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
    private JButton btnSearch, btnAddClase, btnListaDeClases, btnEliminarClase;
    private JTable table;
    private JScrollPane scrollPane;

    public ClasesPanel() {
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        txtSearch = new JTextField(20);
        btnSearch = new JButton("Buscar");
        btnAddClase = new JButton("Añadir Clase");
        btnListaDeClases = new JButton("Lista de Clases");
        btnEliminarClase = new JButton("Eliminar Clase");

        topPanel.add(new JLabel("Buscar:"));
        topPanel.add(txtSearch);
        topPanel.add(btnSearch);
        topPanel.add(btnAddClase);
        topPanel.add(btnListaDeClases);
        topPanel.add(btnEliminarClase);

        add(topPanel, BorderLayout.SOUTH);
        add(btnListaDeClases, BorderLayout.NORTH);
        btnListaDeClases.setBackground(Color.blue);

        table = new JTable();
        scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                busquedaPorNombre();
            }
        });

        btnAddClase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClasesFormDialog formDialog = new ClasesFormDialog(null);
                formDialog.setVisible(true);
            }
        });
        btnListaDeClases.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablaClasesCompleta();
            }
        });
        btnEliminarClase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarClase();
            }
        });

    }

    private void busquedaPorNombre() {

        ClaseData cd = new ClaseData();
        try {
            if (txtSearch.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "El campo de texto está vacío.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                List<Clase> clases = cd.buscarClases(txtSearch.getText());
                if (clases.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se encontró ninguna Clase con ese nombre.");
                    return;
                }

                String[] columnNames = {"ID", "Nombre", "Entrenador", "Horario", "Capacidad", "Estado"};
                DefaultTableModel model = new DefaultTableModel(columnNames, 0);

                for (Clase clase : clases) {
                    Object[] row = new Object[6];
                    row[0] = clase.getIdClase();
                    row[1] = clase.getNombre();
                    row[2] = clase.getEntrenador().getIdEntrenador();
                    row[3] = clase.getHorario().toString();
                    row[4] = clase.getCapacidad();
                    row[5] = clase.isEstado() ? "Activa" : "Inactiva";
                    model.addRow(row);
                }

                table.setModel(model);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al buscar Clases: " + ex.getMessage());
        }

    }

    void tablaClasesCompleta() {

        ClaseData cd = new ClaseData();
        List<Clase> clases = cd.listarClases();

        String[] columnNames = {"ID", "Nombre", "ID_Entrenador", "Horario", "Capacidad", "Estado"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Clase clase : clases) {
            Object[] row = new Object[6];
            row[0] = clase.getIdClase();
            row[1] = clase.getNombre();
            row[2] = clase.getEntrenador().getIdEntrenador();
            row[3] = clase.getHorario();
            row[4] = clase.getCapacidad();
            row[5] = clase.isEstado() ? "Activa" : "Inactiva";
            model.addRow(row);
        }
        table.setModel(model);
    }

    void eliminarClase() {
        int selectedRow = table.getSelectedRow();

        if (selectedRow >= 0) {
            // Obtener el ID del Socio seleccionado
            int idClase = (int) table.getModel().getValueAt(selectedRow, 0);

            // Confirmar la eliminación con un diálogo
            int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este Socio?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                // Eliminar la membresía de la base de datos
                ClaseData cd = new ClaseData();
                cd.eliminarClase(idClase);

                // Actualizar la tabla
                tablaClasesCompleta();

            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un clase para eliminar.");
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

/**
 *
 * @author ramir
 */
import Data.SocioData;
import Entidades.Socio;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class SociosPanel extends JPanel {

    private JTextField txtSearch;
    private JButton btnSearch, btnAddSocio, btnListaDeSocios, btnEliminarSocio;
    private JTable table;
    private JScrollPane scrollPane;

    public SociosPanel() {
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        txtSearch = new JTextField(20);
        btnSearch = new JButton("Buscar");
        btnAddSocio = new JButton("Añadir Socio");
        btnListaDeSocios = new JButton("Lista de Socios");
        btnEliminarSocio = new JButton("Eliminar Socio");

        topPanel.add(new JLabel("Buscar:"));
        topPanel.add(txtSearch);
        topPanel.add(btnSearch);
        topPanel.add(btnAddSocio);
        topPanel.add(btnListaDeSocios);
        topPanel.add(btnEliminarSocio);

        add(topPanel, BorderLayout.SOUTH);
        add(btnListaDeSocios, BorderLayout.NORTH);
        btnListaDeSocios.setBackground(Color.yellow);

        // Inicializar tabla vacía
        inicializarTablaVacia();

        // Action listeners
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                busquedaPorNombre();
            }
        });

        btnAddSocio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SocioFormDialog(null).setVisible(true);

//                tablaSociosCompleta();
            }
        });

        btnListaDeSocios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                tablaSociosCompleta();
            }
        });

        btnEliminarSocio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarSocio();
            }
        });
    }

    void busquedaPorNombre() {
        SocioData sd = new SocioData();

        try {
            if (txtSearch.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "El campo de texto está vacío.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                List<Socio> socios = sd.buscarSocios(txtSearch.getText());
                if (socios.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se encontró ningun Socio con ese nombre.");
                    return;
                }
                Object[][] data = new Object[socios.size()][8];
                for (int i = 0; i < socios.size(); i++) {
                    Socio socio = socios.get(i);
                    data[i][0] = socio.getIdSocio();
                    data[i][1] = socio.getDni();
                    data[i][2] = socio.getNombre();
                    data[i][3] = socio.getApellido();
                    data[i][4] = socio.getEdad();
                    data[i][5] = socio.getCorreo();
                    data[i][6] = socio.getTelefono();
                    data[i][7] = socio.isEstado();

                }
                table.setModel(new javax.swing.table.DefaultTableModel(
                        data,
                        new String[]{"ID", "DNI", "Nombre", "Apellido", "Edad", "Correo", "Teléfono", "Estado"}
                ));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar socios: ");
        }
    }

    void tablaSociosCompleta() {

        SocioData sd = new SocioData();
        List<Socio> socios = sd.listarSocios();

        String[] columnNames = {"ID", "DNI", "Nombre", "Apellido", "Edad", "Correo", "Telefono", "Estado"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Socio socio : socios) {
            Object[] row = new Object[7];
            row[0] = socio.getIdSocio();
            row[1] = socio.getDni();
            row[2] = socio.getNombre();
            row[3] = socio.getApellido();
            row[4] = socio.getEdad();
            row[5] = socio.getCorreo();
            row[6] = socio.isEstado() ? "Activa" : "Inactiva";
            model.addRow(row);
        }
        table.setModel(model);
    }

    void eliminarSocio() {
        int selectedRow = table.getSelectedRow();

        if (selectedRow >= 0) {
            // Obtener el ID del Socio seleccionado
            int idSocio = (int) table.getModel().getValueAt(selectedRow, 0);

            // Confirmar la eliminación con un diálogo
            int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este Socio?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                // Eliminar la membresía de la base de datos
                SocioData sd = new SocioData();
                sd.eliminarSocio(idSocio);

                // Actualizar la tabla
                tablaSociosCompleta();

            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un socio para eliminar.");
        }
    }

    void inicializarTablaVacia() {

        table = new JTable(new Object[0][0], new String[]{"ID", "DNI", "Nombre", "Apellido", "Edad", "Correo", "Teléfono", "Estado"});
        scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
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

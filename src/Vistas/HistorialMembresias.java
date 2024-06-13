/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HistorialMembresias extends javax.swing.JInternalFrame {

    private JTextField txtFiltroSocio;
    private JButton btnFiltrar;
    private JTable table;

    public HistorialMembresias() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Historial de Membresías");
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panelFiltro = new JPanel(new GridLayout(1, 3, 10, 10));

        JLabel lblFiltroSocio = new JLabel("Filtrar por Socio:");
        txtFiltroSocio = new JTextField();
        btnFiltrar = new JButton("Filtrar");
        btnFiltrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para filtrar historial
                String filtroSocio = txtFiltroSocio.getText();
                JOptionPane.showMessageDialog(HistorialMembresias.this, "Filtrando historial para el socio: " + filtroSocio);
            }
        });

        panelFiltro.add(lblFiltroSocio);
        panelFiltro.add(txtFiltroSocio);
        panelFiltro.add(btnFiltrar);

        // Columnas de la tabla
        String[] columns = {"Socio", "Cantidad de Pases", "Duración", "Fecha de Inicio", "Estado"};

        // Datos de ejemplo (se deberían obtener de la base de datos)
        Object[][] data = {
            {"Juan Pérez", "10", "3 meses", "01/01/2024", "Activa"},
            {"María Gómez", "20", "6 meses", "01/02/2024", "Vencida"},
            {"Carlos Rodríguez", "15", "5 meses", "01/03/2024", "Activa"}
        };

        table = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(table);

        getContentPane().add(panelFiltro, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        pack();
        setLocation(50, 50); // Posición inicial dentro del JDesktopPane
    }

    public static void main(String[] args) {
        // Crear un marco para demostrar la funcionalidad de JInternalFrame
        JFrame frame = new JFrame("Demo de JInternalFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JDesktopPane desktopPane = new JDesktopPane();
        frame.add(desktopPane);

        HistorialMembresias historialMembresiasFrame = new HistorialMembresias();
        desktopPane.add(historialMembresiasFrame);
        historialMembresiasFrame.setVisible(true);

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
            .addGap(0, 588, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

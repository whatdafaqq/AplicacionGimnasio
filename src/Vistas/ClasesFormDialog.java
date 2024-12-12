        /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

/**
 *
 * @author ramir
 */
import Data.ClaseData;
import Data.EntrenadorData;
import Entidades.Clase;
import Entidades.Entrenador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.List;

public class ClasesFormDialog extends JDialog {
    private JTextField txtNombre;
    private JComboBox<Entrenador> cmbEntrenador;
    private JTextField txtHorario;
    private JTextField txtCapacidad;
    private JCheckBox chkEstado;
    private JButton btnSave;
    private JButton btnBuscar;
    private JTextField txtBuscar;
    private JTable tablaClases;

    public ClasesFormDialog(Frame owner) {
        super(owner, "Gestionar Clases", true);
        setSize(400, 250);
        setLayout(new BorderLayout());
        setLocationRelativeTo(owner);

        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        txtNombre = new JTextField(20);
        cmbEntrenador = new JComboBox<>(getEntrenadores().toArray(new Entrenador[0]));
        txtHorario = new JTextField(20);
        txtCapacidad = new JTextField(20);
        chkEstado = new JCheckBox("Activa");
        btnSave = new JButton("Guardar");

        formPanel.add(new JLabel("Nombre:"));
        formPanel.add(txtNombre);
        formPanel.add(new JLabel("Entrenador:"));
        formPanel.add(cmbEntrenador);
        formPanel.add(new JLabel("Horario (HH:MM):"));
        formPanel.add(txtHorario);
        formPanel.add(new JLabel("Capacidad:"));
        formPanel.add(txtCapacidad);
        formPanel.add(new JLabel("Estado:"));
        formPanel.add(chkEstado);
        formPanel.add(new JLabel(""));
        formPanel.add(btnSave);

        JPanel searchPanel = new JPanel(new FlowLayout());
        txtBuscar = new JTextField(20);
        btnBuscar = new JButton("Buscar");
        searchPanel.add(new JLabel("Buscar Clase:"));
        searchPanel.add(txtBuscar);
        searchPanel.add(btnBuscar);

        tablaClases = new JTable();
        JScrollPane scrollPane = new JScrollPane(tablaClases);

        add(formPanel, BorderLayout.NORTH);
        add(searchPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                logicaGuardadoDeClase();
               
        // Actualizar la tabla inicialmente
//        ClaseData cd = new ClaseData();
//        List<Clase> clases = cd.listarClases();
//        actualizarTablaClases(clases);
    }
//
            
            private void logicaGuardadoDeClase(){
                if (txtNombre.getText().isBlank()|| txtHorario.getText().isBlank()
                || txtCapacidad.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, rellena todos los campos antes de agregar una Clase.",
                    "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return;
            
        }try{
            String nombre = txtNombre.getText();
                    Entrenador entrenador = (Entrenador) cmbEntrenador.getSelectedItem();
                    LocalTime horario = LocalTime.parse(txtHorario.getText());
                    int capacidad = Integer.parseInt(txtCapacidad.getText());
                    boolean estado = chkEstado.isSelected();

                    Clase clase = new Clase(0, nombre, entrenador, horario, capacidad, estado);
                    ClaseData cd = new ClaseData();
                    cd.agregarClase(clase);              
                    dispose();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error al agregar una clase: " + ex.getMessage());
        }
            }
        });
            }
            
    private List<Entrenador> getEntrenadores() {
        EntrenadorData ed = new EntrenadorData();
        try {
            return ed.listaEntrenadores();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar entrenadores: " + ex.getMessage());
            return new java.util.ArrayList<>();
        }
    }
////
//    private void actualizarTablaClases(List<Clase> clases) {
//        String[] columnNames = {"ID", "Nombre", "Entrenador", "Horario", "Capacidad", "Estado"};
//        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
//
//        for (Clase clase : clases) {
//            Object[] row = new Object[6];
//            row[0] = clase.getIdClase();
//            row[1] = clase.getNombre();
//            row[2] = clase.getEntrenador().getNombre();
//            row[3] = clase.getHorario().toString();
//            row[4] = clase.getCapacidad();
//            row[5] = clase.isEstado() ? "Activa" : "Inactiva";
//            model.addRow(row);
//        }
//
//        tablaClases.setModel(model);
//    }







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

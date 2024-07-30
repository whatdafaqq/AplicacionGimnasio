/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Data.Conexion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 *
 * @author ramir
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public MainFrame() {
        setTitle("Administración del Gimnasio");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Color backgroundColor = new Color(0, 102, 204);
        Color tabBackgroundColor = new Color(176, 196, 222); 
        Color menuBackgroundColor = Color.WHITE;
        Color menuForegroundColor = Color.BLACK;

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Entrenadores", new EntrenadoresPanel());
        tabbedPane.addTab("Clases", new ClasesPanel());
        tabbedPane.addTab("Socios", new SociosPanel());
        tabbedPane.addTab("Membresias", new SociosPanel());

        tabbedPane.setBackground(tabBackgroundColor);
        add(tabbedPane, BorderLayout.CENTER);

        // Cerrar la conexión a la base de datos al salir
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                try {
                    Conexion.closeConnection();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        // Crear barra de menú
        JMenuBar menuBar = new JMenuBar();

        // Menú Socios
        JMenu sociosMenu = new JMenu("Socios");
        sociosMenu.setBackground(menuBackgroundColor);
        sociosMenu.setForeground(menuForegroundColor);
        JMenuItem gestionarSociosItem = new JMenuItem("Gestionar Socios");
        gestionarSociosItem.setBackground(menuBackgroundColor);
        gestionarSociosItem.setForeground(menuForegroundColor);
        gestionarSociosItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(new SociosPanel());
                revalidate();
            }
        });
        sociosMenu.add(gestionarSociosItem);

        // Menú Entrenadores
        JMenu entrenadoresMenu = new JMenu("Entrenadores");
        entrenadoresMenu.setBackground(menuBackgroundColor);
        entrenadoresMenu.setForeground(menuForegroundColor);
        JMenuItem gestionarEntrenadoresItem = new JMenuItem("Gestionar Entrenadores");
        gestionarEntrenadoresItem.setBackground(menuBackgroundColor);
        gestionarEntrenadoresItem.setForeground(menuForegroundColor);
        gestionarEntrenadoresItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(new EntrenadoresPanel());
                revalidate();
            }
        });
        entrenadoresMenu.add(gestionarEntrenadoresItem);

        // Menú Clases
        JMenu clasesMenu = new JMenu("Clases");
        clasesMenu.setBackground(menuBackgroundColor);
        clasesMenu.setForeground(menuForegroundColor);
        JMenuItem gestionarClasesItem = new JMenuItem("Gestionar Clases");
        gestionarClasesItem.setBackground(menuBackgroundColor);
        gestionarClasesItem.setForeground(menuForegroundColor);
        gestionarClasesItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(new ClasesPanel());
                revalidate();
            }
        });
        clasesMenu.add(gestionarClasesItem);

        // Menú Membresías
        JMenu membresiasMenu = new JMenu("Membresías");
        membresiasMenu.setBackground(menuBackgroundColor);
        membresiasMenu.setForeground(menuForegroundColor);
        JMenuItem gestionarMembresiasItem = new JMenuItem("Gestionar Membresías");
        gestionarMembresiasItem.setBackground(menuBackgroundColor);
        gestionarMembresiasItem.setForeground(menuForegroundColor);
        gestionarMembresiasItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(new MembresiasPanel());
                revalidate();
            }
        });
        membresiasMenu.add(gestionarMembresiasItem);

        // Añadir menús a la barra de menú
        menuBar.add(sociosMenu);
        menuBar.add(entrenadoresMenu);
        menuBar.add(clasesMenu);
        menuBar.add(membresiasMenu);

        setJMenuBar(menuBar);
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(backgroundColor);
        setContentPane(mainPanel);
        /**
         * setJMenuBar(menuBar); setContentPane(new JPanel());
         */
        // initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
                MainFrame frame = new MainFrame();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Data.Conexion;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

/**
 *
 * @author ramir
 */
public class MainFrame extends javax.swing.JFrame {

    private JPanel mainPanel; // Cambiar de variable local a atributo de clase
    private JPanel contentPanel; // Panel dinámico para el contenido central

    /**
     * Creates new form NewJFrame
     */
    public MainFrame() {

        setTitle("Administración del Gimnasio");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear el panel principal
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.DARK_GRAY);

        //Etiqueta
        JLabel headerLabel = new JLabel("Sistema de Gestión de Gimnasio", JLabel.CENTER);
        headerLabel.setFont(new Font("Oswald", Font.BOLD, 24));
        headerLabel.setForeground(Color.white);
        mainPanel.add(headerLabel, BorderLayout.NORTH);

        //new
        // Panel dinámico para el contenido (cambiará según los botones)
        contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(Color.DARK_GRAY);

        // Panel para la imagen o GIF
        JPanel gifPanel = new JPanel(new BorderLayout());
        gifPanel.setBackground(Color.DARK_GRAY);
        gifPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Bordes transparentes

        // Crear etiqueta para mostrar el GIF
        JLabel gifLabel = new JLabel();
        gifLabel.setHorizontalAlignment(JLabel.CENTER);

        // Cargar el GIF o imagen
        try {
            ImageIcon gifIcon = new ImageIcon(getClass().getResource("/icons/cbum.gif")); // Ruta del GIF
            gifLabel.setIcon(gifIcon);// Establecer el GIF en la etiqueta
        } catch (Exception e) {
            System.out.println("No se pudo cargar la imagen o GIF: " + e.getMessage());
        }

        JLabel gifSubtitle = new JLabel("Entrena como un profesional", JLabel.CENTER);
        gifSubtitle.setFont(new Font("Roboto", Font.ITALIC, 18));
        gifSubtitle.setForeground(Color.LIGHT_GRAY);

        // Añadir el GIF al panel
        gifPanel.add(gifLabel, BorderLayout.CENTER);
        gifPanel.add(gifSubtitle, BorderLayout.SOUTH);

        contentPanel.add(gifPanel, BorderLayout.CENTER);

        // Configurar el panel principal para que el GIF tenga espacio visible
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Crear barra de menú
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        menuBar.setBackground(Color.DARK_GRAY);

        JButton btnMenuPrincipal = crearBoton("Menu", "menu.png");
        JButton btnSocios = crearBoton("Socios", "socios.png");
        JButton btnEntrenadores = crearBoton("Entrenadores", "entrenadores.png");
        JButton btnClases = crearBoton("Clases", "clases.png");
        JButton btnMembresias = crearBoton("Membresías", "membresias.png");

        menuBar.add(btnMenuPrincipal);
        menuBar.add(btnSocios);
        menuBar.add(btnEntrenadores);
        menuBar.add(btnClases);
        menuBar.add(btnMembresias);

        mainPanel.add(menuBar, BorderLayout.SOUTH);

//
//         setJMenuBar(menuBar);
//         
        // Eventos a los botones
        btnMenuPrincipal.addActionListener(e -> mostrarPanelInicial());
        btnSocios.addActionListener(e -> cambiarPanel(new SociosPanel()));
        btnEntrenadores.addActionListener(e -> cambiarPanel(new EntrenadoresPanel()));
        btnClases.addActionListener(e -> cambiarPanel(new ClasesPanel()));
        btnMembresias.addActionListener(e -> cambiarPanel(new MembresiasPanel()));

        // Mostrar la ventana
        setContentPane(mainPanel);
        setVisible(true);

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
    }

    private JButton crearBoton(String texto, String iconoPath) {
        JButton boton = new JButton(texto);

        boton.setForeground(Color.red);
        boton.setFont(new Font("Roboto", Font.BOLD, 16));
        boton.setBackground(Color.DARK_GRAY);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Intentar cargar el icono si existe
        try {
            ImageIcon icono = new ImageIcon(getClass().getResource("/icons/" + iconoPath));
            Image imagenEscalada = icono.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Ajusta el tamaño (ancho x alto)
            boton.setIcon(new ImageIcon(imagenEscalada));
        } catch (Exception e) {
            System.out.println("Icono no encontrado: " + iconoPath);
        }

        return boton;
    }

    private void cambiarPanel(JPanel nuevoPanel) {
      contentPanel.removeAll();

    // Estilo uniforme para todos los paneles dinámicos
    nuevoPanel.setBackground(Color.DARK_GRAY); // Fondo oscuro
    nuevoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Márgenes

    contentPanel.add(nuevoPanel, BorderLayout.CENTER);
    contentPanel.revalidate();
    contentPanel.repaint();
    }

    private void mostrarPanelInicial() {
        // Restaurar el contenido inicial (GIF y subtítulo)
        JPanel panelInicial = new JPanel(new BorderLayout());
        panelInicial.setBackground(Color.DARK_GRAY); // Asegurar el color de fondo oscuro

        JLabel gifLabel = new JLabel();
        gifLabel.setHorizontalAlignment(JLabel.CENTER);

        try {
            ImageIcon gifIcon = new ImageIcon(getClass().getResource("/icons/cbum.gif"));
            gifLabel.setIcon(gifIcon);
        } catch (Exception e) {
            System.out.println("No se pudo cargar la imagen o GIF: " + e.getMessage());
        }

        JLabel gifSubtitle = new JLabel("Entrena como un profesional", JLabel.CENTER);
        gifSubtitle.setFont(new Font("Roboto", Font.ITALIC, 18));
        gifSubtitle.setForeground(Color.LIGHT_GRAY);

        panelInicial.add(gifLabel, BorderLayout.CENTER);
        panelInicial.add(gifSubtitle, BorderLayout.SOUTH);

        cambiarPanel(panelInicial);

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

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

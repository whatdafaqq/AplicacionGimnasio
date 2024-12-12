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
 private JLabel imgLabel;
 private JPanel mainPanel; // Cambiar de variable local a atributo de clase
 

    /**
     * Creates new form NewJFrame
     */
    public MainFrame() {
        
        
        setTitle("Administración del Gimnasio");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


// // Panel principal con BorderLayout para centrar el contenido
//        JPanel mainPanel = new JPanel(new BorderLayout());
//        mainPanel.setBackground(new Color(0, 102, 202));  // Fondo del panel principal

//new

 // Crear el panel principal
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.DARK_GRAY);
        
        // Encabezado
         JLabel headerLabel = new JLabel("Sistema de Gestión de Gimnasio", JLabel.CENTER);
        headerLabel.setFont(new Font("Oswald", Font.BOLD, 24));
        headerLabel.setForeground(Color.white);
        headerLabel.setOpaque(true);
        headerLabel.setBackground(Color.RED);
        mainPanel.add(headerLabel, BorderLayout.NORTH);
        
        
//         Panel central (contenido principal)
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2, 2, 10, 10));
        centerPanel.setBackground(Color.DARK_GRAY);

        
//// Crear el JLabel con un tamaño preferido
//        imgLabel = new JLabel();
//        imgLabel.setPreferredSize(new Dimension(200, 100)); // Ajusta el tamaño según tus necesidades
//        imgLabel.setBackground(Color.WHITE);
// Cargar y establecer el icono
//        Icon mIcono = new ImageIcon(getClass().getResource("dumbbell.png"));
//        imgLabel.setIcon(mIcono);
//        imgLabel.setHorizontalAlignment(SwingConstants.CENTER); // Centrar la imagen
//        
//        // Agregar el JLabel al panel principal
//        mainPanel.add(imgLabel, BorderLayout.CENTER);
//        
//        // Configurar el contentPane del JFrame
//        setContentPane(mainPanel);
//        
//        Color backgroundColor = new Color(0, 102, 202);
//        Color tabBackgroundColor = new Color(176, 196, 222); 
//        Color menuBackgroundColor = Color.WHITE;
//        Color menuForegroundColor = Color.red;

        //Lo que sigue  es new.
        
        // Botones estilizados
        JButton btnMenuPrincipal = crearBoton("Menu", "menu.png");
        JButton btnSocios = crearBoton("Socios", "socios.png");
        JButton btnEntrenadores = crearBoton("Entrenadores", "entrenadores.png");
        JButton btnClases = crearBoton("Clases", "clases.png");
        JButton btnMembresias = crearBoton("Membresías", "membresias.png");
        
        centerPanel.add(btnMenuPrincipal);
       centerPanel.add(btnSocios);
        centerPanel.add(btnEntrenadores);
        centerPanel.add(btnClases);
        centerPanel.add(btnMembresias);

//        mainPanel.add(centerPanel, BorderLayout.CENTER);
        
//        // Botón para volver al menú principal
//        JButton btnMenuPrincipal = new JButton("Volver al Inicio");
//        btnMenuPrincipal.setFont(new Font("Roboto", Font.BOLD, 16));
//        btnMenuPrincipal.setForeground(Color.WHITE);
//        btnMenuPrincipal.setBackground(new Color(30, 144, 255));
//        btnMenuPrincipal.setFocusPainted(false);
//        btnMenuPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        
        btnMenuPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
volverAlInicio();            }
        });

//        mainPanel.add(btnMenuPrincipal, BorderLayout.SOUTH);
        add(mainPanel);

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
//        JMenu sociosMenu = new JMenu("Socios");
//        sociosMenu.setBackground(menuBackgroundColor);
//        sociosMenu.setForeground(menuForegroundColor);
//        JMenuItem gestionarSociosItem = new JMenuItem("Gestionar Socios");
//        gestionarSociosItem.setBackground(menuBackgroundColor);
//        gestionarSociosItem.setForeground(menuForegroundColor);
        
        btnSocios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(new SociosPanel());
                revalidate();
                
            }
        });
//        sociosMenu.add(gestionarSociosItem);

        // Menú Entrenadores
//        JMenu entrenadoresMenu = new JMenu("Entrenadores");
//        entrenadoresMenu.setBackground(menuBackgroundColor);
//        entrenadoresMenu.setForeground(menuForegroundColor);
//        JMenuItem gestionarEntrenadoresItem = new JMenuItem("Gestionar Entrenadores");
//        gestionarEntrenadoresItem.setBackground(menuBackgroundColor);
//        gestionarEntrenadoresItem.setForeground(menuForegroundColor);

        btnEntrenadores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(new EntrenadoresPanel());
                revalidate();
            }
        });
//        entrenadoresMenu.add(gestionarEntrenadoresItem);
        
        

        // Menú Clases
//        JMenu clasesMenu = new JMenu("Clases");
//        clasesMenu.setBackground(menuBackgroundColor);
//        clasesMenu.setForeground(menuForegroundColor);
//        JMenuItem gestionarClasesItem = new JMenuItem("Gestionar Clases");
//        gestionarClasesItem.setBackground(menuBackgroundColor);
//        gestionarClasesItem.setForeground(menuForegroundColor);

        btnClases.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(new ClasesPanel());
                revalidate();
            }
        });
//        clasesMenu.add(gestionarClasesItem);

        // Menú Membresías
//        JMenu membresiasMenu = new JMenu("Membresías");
//        membresiasMenu.setBackground(menuBackgroundColor);
//        membresiasMenu.setForeground(menuForegroundColor);
//        JMenuItem gestionarMembresiasItem = new JMenuItem("Gestionar Membresías");
//        gestionarMembresiasItem.setBackground(menuBackgroundColor);
//        gestionarMembresiasItem.setForeground(menuForegroundColor);

        btnMembresias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(new MembresiasPanel());
                revalidate();
            }
        });
//        membresiasMenu.add(gestionarMembresiasItem);

        // Añadir menús a la barra de menú
        menuBar.add(btnMenuPrincipal);
        menuBar.add(btnSocios);
        menuBar.add(btnEntrenadores);
        menuBar.add(btnClases);
        menuBar.add(btnMembresias);

        setJMenuBar(menuBar);
        // Mostrar la ventana
        setVisible(true);
        
//        JPanel mainPanel = new JPanel();
//        mainPanel.setBackground(backgroundColor);
        setContentPane(mainPanel);
        /**
         * setJMenuBar(menuBar); setContentPane(new JPanel());
         */
        // initComponents();
        
        
        // Panel para la imagen o GIF
JLabel gifLabel = new JLabel();
gifLabel.setHorizontalAlignment(JLabel.CENTER);

// Cargar el GIF o imagen
try {
    ImageIcon gifIcon = new ImageIcon(getClass().getResource("/icons/cbum.gif")); // Ruta del GIF
    gifLabel.setIcon(gifIcon);
} catch (Exception e) {
    System.out.println("No se pudo cargar la imagen o GIF: " + e.getMessage());
}

// Agregar el GIF al espacio central
mainPanel.add(gifLabel, BorderLayout.CENTER);
//centerPanel.add(gifLabel, BorderLayout.CENTER);

    }

    
    private JButton crearBoton(String texto, String iconoPath) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Roboto", Font.BOLD, 16));
        boton.setForeground(Color.WHITE);
        boton.setBackground(new Color(30, 144, 255)); // Azul gimnasio
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
    
    // Método para volver al inicio
private void volverAlInicio() {
    setContentPane(mainPanel);
    revalidate(); // Actualizar la interfaz gráfica
    repaint();
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

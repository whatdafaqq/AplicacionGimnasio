/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import javax.swing.JMenuItem;

/**
 *
 * @author rodrigo
 */
public class GymApp extends javax.swing.JFrame {

    public GymApp() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMGestionSocios = new javax.swing.JMenu();
        jM_Item_AddSocio = new javax.swing.JMenuItem();
        jM_Item_ListSocios = new javax.swing.JMenuItem();
        jM_Item_BuscarSocio = new javax.swing.JMenuItem();
        jMGestionEntrenadores = new javax.swing.JMenu();
        jM_Item_NewEntrenador = new javax.swing.JMenuItem();
        jM_Item_ListEntrenadores = new javax.swing.JMenuItem();
        jM_Item_BuscarEntrenador = new javax.swing.JMenuItem();
        jMGestionClases = new javax.swing.JMenu();
        jM_Item_AddClase = new javax.swing.JMenuItem();
        jM_Item_ListClases = new javax.swing.JMenuItem();
        jM_Item_BuscarClase = new javax.swing.JMenuItem();
        jM_Item_InscribirSocioAClase = new javax.swing.JMenuItem();
        jMGestionMembresias = new javax.swing.JMenu();
        jM_Item_NuevaMembresia = new javax.swing.JMenuItem();
        jM_Item_HistorialMembresia = new javax.swing.JMenuItem();
        jM_Item_GestionarMembresia = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout EscritorioLayout = new javax.swing.GroupLayout(Escritorio);
        Escritorio.setLayout(EscritorioLayout);
        EscritorioLayout.setHorizontalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1304, Short.MAX_VALUE)
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );

        jMGestionSocios.setText("Socios");

        jM_Item_AddSocio.setText("AñadirSocio");
        jM_Item_AddSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jM_Item_AddSocioActionPerformed(evt);
            }
        });
        jMGestionSocios.add(jM_Item_AddSocio);

        jM_Item_ListSocios.setText("VerSocio");
        jM_Item_ListSocios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jM_Item_ListSociosActionPerformed(evt);
            }
        });
        jMGestionSocios.add(jM_Item_ListSocios);

        jM_Item_BuscarSocio.setText("BuscarSocio");
        jM_Item_BuscarSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jM_Item_BuscarSocioActionPerformed(evt);
            }
        });
        jMGestionSocios.add(jM_Item_BuscarSocio);

        jMenuBar1.add(jMGestionSocios);

        jMGestionEntrenadores.setText("Entrenadores");

        jM_Item_NewEntrenador.setText("Añadir Entrenador");
        jM_Item_NewEntrenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jM_Item_NewEntrenadorActionPerformed(evt);
            }
        });
        jMGestionEntrenadores.add(jM_Item_NewEntrenador);

        jM_Item_ListEntrenadores.setText("Ver Entrenadores");
        jM_Item_ListEntrenadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jM_Item_ListEntrenadoresActionPerformed(evt);
            }
        });
        jMGestionEntrenadores.add(jM_Item_ListEntrenadores);

        jM_Item_BuscarEntrenador.setText("Buscar Entrenador");
        jM_Item_BuscarEntrenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jM_Item_BuscarEntrenadorActionPerformed(evt);
            }
        });
        jMGestionEntrenadores.add(jM_Item_BuscarEntrenador);

        jMenuBar1.add(jMGestionEntrenadores);

        jMGestionClases.setText("Clases");

        jM_Item_AddClase.setText("Añadir Clase");
        jM_Item_AddClase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jM_Item_AddClaseActionPerformed(evt);
            }
        });
        jMGestionClases.add(jM_Item_AddClase);

        jM_Item_ListClases.setText("Lista de Clases");
        jM_Item_ListClases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jM_Item_ListClasesActionPerformed(evt);
            }
        });
        jMGestionClases.add(jM_Item_ListClases);

        jM_Item_BuscarClase.setText("Buscar Clase");
        jM_Item_BuscarClase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jM_Item_BuscarClaseActionPerformed(evt);
            }
        });
        jMGestionClases.add(jM_Item_BuscarClase);

        jM_Item_InscribirSocioAClase.setText("Incribir Socio a Clases");
        jM_Item_InscribirSocioAClase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jM_Item_InscribirSocioAClaseActionPerformed(evt);
            }
        });
        jMGestionClases.add(jM_Item_InscribirSocioAClase);

        jMenuBar1.add(jMGestionClases);

        jMGestionMembresias.setText("Membresias");

        jM_Item_NuevaMembresia.setText("NuevaMembresia");
        jM_Item_NuevaMembresia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jM_Item_NuevaMembresiaActionPerformed(evt);
            }
        });
        jMGestionMembresias.add(jM_Item_NuevaMembresia);

        jM_Item_HistorialMembresia.setText("Historial De Membresias");
        jM_Item_HistorialMembresia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jM_Item_HistorialMembresiaActionPerformed(evt);
            }
        });
        jMGestionMembresias.add(jM_Item_HistorialMembresia);

        jM_Item_GestionarMembresia.setText("Gestionar Membresias");
        jM_Item_GestionarMembresia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jM_Item_GestionarMembresiaActionPerformed(evt);
            }
        });
        jMGestionMembresias.add(jM_Item_GestionarMembresia);

        jMenuBar1.add(jMGestionMembresias);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addComponent(Escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jM_Item_AddSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jM_Item_AddSocioActionPerformed
        JMenuItem source = (JMenuItem) (evt.getSource());

        if (source == jM_Item_AddSocio) {
            Escritorio.removeAll();
            Escritorio.repaint();

            AñadirSocio añadirSocio = new AñadirSocio();
            Escritorio.add(añadirSocio);
            añadirSocio.setVisible(true);
        }
    }//GEN-LAST:event_jM_Item_AddSocioActionPerformed

    private void jM_Item_ListSociosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jM_Item_ListSociosActionPerformed
        JMenuItem source = (JMenuItem) (evt.getSource());

        if (source == jM_Item_ListSocios) {
            Escritorio.removeAll();
            Escritorio.repaint();

            VerSocios verSocios = new VerSocios();
            Escritorio.add(verSocios);
            verSocios.setVisible(true);
        }
    }//GEN-LAST:event_jM_Item_ListSociosActionPerformed

    private void jM_Item_BuscarSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jM_Item_BuscarSocioActionPerformed
        JMenuItem source = (JMenuItem) (evt.getSource());

        if (source == jM_Item_BuscarSocio) {
            Escritorio.removeAll();
            Escritorio.repaint();

            BuscarSocio buscarSocio = new BuscarSocio();
            Escritorio.add(buscarSocio);
            buscarSocio.setVisible(true);
        }
    }//GEN-LAST:event_jM_Item_BuscarSocioActionPerformed

    private void jM_Item_NewEntrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jM_Item_NewEntrenadorActionPerformed
        JMenuItem source = (JMenuItem) (evt.getSource());

        if (source == jM_Item_NewEntrenador) {
            Escritorio.removeAll();
            Escritorio.repaint();

            AñadirEntrenador añadirEntrenador = new AñadirEntrenador();
            Escritorio.add(añadirEntrenador);
            añadirEntrenador.setVisible(true);
        }
    }//GEN-LAST:event_jM_Item_NewEntrenadorActionPerformed

    private void jM_Item_ListEntrenadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jM_Item_ListEntrenadoresActionPerformed
        JMenuItem source = (JMenuItem) (evt.getSource());

        if (source == jM_Item_ListEntrenadores) {
            Escritorio.removeAll();
            Escritorio.repaint();

            VerEntrenadores verEntrenadores = new VerEntrenadores();
            Escritorio.add(verEntrenadores);
            verEntrenadores.setVisible(true);
        }
    }//GEN-LAST:event_jM_Item_ListEntrenadoresActionPerformed

    private void jM_Item_BuscarEntrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jM_Item_BuscarEntrenadorActionPerformed
        JMenuItem source = (JMenuItem) (evt.getSource());

        if (source == jM_Item_BuscarEntrenador) {
            Escritorio.removeAll();
            Escritorio.repaint();

            BuscarEntrenador buscarEntrenador = new BuscarEntrenador();
            Escritorio.add(buscarEntrenador);
            buscarEntrenador.setVisible(true);
        }
    }//GEN-LAST:event_jM_Item_BuscarEntrenadorActionPerformed

    private void jM_Item_AddClaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jM_Item_AddClaseActionPerformed
        JMenuItem source = (JMenuItem) (evt.getSource());

        if (source == jM_Item_AddClase) {
            Escritorio.removeAll();
            Escritorio.repaint();

            AñadirClase añadirClase = new AñadirClase();
            Escritorio.add(añadirClase);
            añadirClase.setVisible(true);
        }
    }//GEN-LAST:event_jM_Item_AddClaseActionPerformed

    private void jM_Item_ListClasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jM_Item_ListClasesActionPerformed
        JMenuItem source = (JMenuItem) (evt.getSource());

        if (source == jM_Item_ListClases) {
            Escritorio.removeAll();
            Escritorio.repaint();

            ListClases listClases = new ListClases();
            Escritorio.add(listClases);
            listClases.setVisible(true);
        }
    }//GEN-LAST:event_jM_Item_ListClasesActionPerformed

    private void jM_Item_BuscarClaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jM_Item_BuscarClaseActionPerformed
        JMenuItem source = (JMenuItem) (evt.getSource());

        if (source == jM_Item_BuscarClase) {
            Escritorio.removeAll();
            Escritorio.repaint();

            BuscarClase buscarClase = new BuscarClase();
            Escritorio.add(buscarClase);
            buscarClase.setVisible(true);
        }
    }//GEN-LAST:event_jM_Item_BuscarClaseActionPerformed

    private void jM_Item_InscribirSocioAClaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jM_Item_InscribirSocioAClaseActionPerformed
        JMenuItem source = (JMenuItem) (evt.getSource());

        if (source == jM_Item_InscribirSocioAClase) {
            Escritorio.removeAll();
            Escritorio.repaint();

            InscribirSocioClase inscribirSocioClase = new InscribirSocioClase();
            Escritorio.add(inscribirSocioClase);
            inscribirSocioClase.setVisible(true);
        }
    }//GEN-LAST:event_jM_Item_InscribirSocioAClaseActionPerformed

    private void jM_Item_NuevaMembresiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jM_Item_NuevaMembresiaActionPerformed
        JMenuItem source = (JMenuItem) (evt.getSource());

        if (source == jM_Item_NuevaMembresia) {
            Escritorio.removeAll();
            Escritorio.repaint();

            RegistrarMembresia registrarMembresia = new RegistrarMembresia();
            Escritorio.add(registrarMembresia);
            registrarMembresia.setVisible(true);
        }
    }//GEN-LAST:event_jM_Item_NuevaMembresiaActionPerformed

    private void jM_Item_HistorialMembresiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jM_Item_HistorialMembresiaActionPerformed
        JMenuItem source = (JMenuItem) (evt.getSource());

        if (source == jM_Item_HistorialMembresia) {
            Escritorio.removeAll();
            Escritorio.repaint();

            HistorialMembresias historialMembresias = new HistorialMembresias();
            Escritorio.add(historialMembresias);
            historialMembresias.setVisible(true);
        }
    }//GEN-LAST:event_jM_Item_HistorialMembresiaActionPerformed

    private void jM_Item_GestionarMembresiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jM_Item_GestionarMembresiaActionPerformed
        JMenuItem source = (JMenuItem) (evt.getSource());

        if (source == jM_Item_GestionarMembresia) {
            Escritorio.removeAll();
            Escritorio.repaint();

            GestionarMembresia gestionarMembresia = new GestionarMembresia();
            Escritorio.add(gestionarMembresia);
            gestionarMembresia.setVisible(true);
        }
    }//GEN-LAST:event_jM_Item_GestionarMembresiaActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GymApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GymApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GymApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GymApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GymApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Escritorio;
    private javax.swing.JMenu jMGestionClases;
    private javax.swing.JMenu jMGestionEntrenadores;
    private javax.swing.JMenu jMGestionMembresias;
    private javax.swing.JMenu jMGestionSocios;
    private javax.swing.JMenuItem jM_Item_AddClase;
    private javax.swing.JMenuItem jM_Item_AddSocio;
    private javax.swing.JMenuItem jM_Item_BuscarClase;
    private javax.swing.JMenuItem jM_Item_BuscarEntrenador;
    private javax.swing.JMenuItem jM_Item_BuscarSocio;
    private javax.swing.JMenuItem jM_Item_GestionarMembresia;
    private javax.swing.JMenuItem jM_Item_HistorialMembresia;
    private javax.swing.JMenuItem jM_Item_InscribirSocioAClase;
    private javax.swing.JMenuItem jM_Item_ListClases;
    private javax.swing.JMenuItem jM_Item_ListEntrenadores;
    private javax.swing.JMenuItem jM_Item_ListSocios;
    private javax.swing.JMenuItem jM_Item_NewEntrenador;
    private javax.swing.JMenuItem jM_Item_NuevaMembresia;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}

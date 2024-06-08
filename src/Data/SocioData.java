/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;
import Entidades.Socio;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ramir
 */
public class SocioData {

    private Connection conn = null;

    public SocioData() {
      conn = Conexion.getConnection();
    }

    public void agregarSocio(Socio s) {
        String sql = "insert into socios(DNI, Nombre, Apellido, Edad, Correo, Telefono, Estado)"
                + "values (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getDni());
            ps.setString(2, s.getNombre());
            ps.setString(3, s.getApellido());
            ps.setInt(4, s.getEdad());
            ps.setString(5, s.getCorreo());
            ps.setString(6, s.getTelefono());
            ps.setBoolean(7, s.isEstado());
            ps.executeQuery();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                s.setIdSocio(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Socio Agregado con exito!");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar un socio");
        }
        
        
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Entidades.Socio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, s.getDni());
            ps.setString(2, s.getNombre());
            ps.setString(3, s.getApellido());
            ps.setInt(4, s.getEdad());
            ps.setString(5, s.getCorreo());
            ps.setString(6, s.getTelefono());
            ps.setBoolean(7, s.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                s.setIdSocio(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Socio Agregado con exito!");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar un socio");
            ex.printStackTrace();
        }

    }

    public List<Socio> listarSocios() {
        String sql = "select * from socios";
         ArrayList<Socio> lista = new ArrayList<>();
        try {
            Statement ps = conn.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                Socio socio = new Socio(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString("Apellido"),         
                rs.getInt(5),
                rs.getString(6),
                rs.getString(7),
                rs.getBoolean(8));
                
                lista.add(socio);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar visualizar los socios");
        }
        return lista;
        
        
    }
    
    public void actualizarSocio(Socio s){
        String sql = "update socios set DNI, Apellido=?, Edad=?, Correo=?, Telefono=?, Estado=? where ID_Socio=?";
          
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.getResultSet();
            ps.setString(1, s.getDni());
            ps.setString(2, s.getNombre());
            ps.setString(3, s.getApellido());
            ps.setInt(4, s.getEdad());
            ps.setString(5, s.getCorreo());
            ps.setString(6, s.getTelefono());
            ps.setBoolean(7, s.isEstado());
            ps.setInt(8, s.getIdSocio());
            ps.executeUpdate();
        } catch (SQLException ex) {
JOptionPane.showMessageDialog(null, "Error al actualizar un socio");
        }
                
    }
    
    public void eliminarSocio(int id){
        String sql ="delete * from socio";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
           ps.setInt(1, id);
             ps.executeUpdate();
        } catch (SQLException ex) {
JOptionPane.showMessageDialog(null, "Error al eliminar un socio");                
                }
        
        
    }
    
    public Socio buscarSocioPorNombre(String nombre) {
        String sql = "SELECT * FROM socio WHERE nombre = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Socio socio = new Socio();
                socio.setIdSocio(rs.getInt("ID_Socio"));
                socio.setNombre(rs.getString("Nombre"));
                socio.setApellido(rs.getString("Apellido"));
                socio.setDni(rs.getString("DNI"));
                 socio.setCorreo(rs.getString("Correo"));
                socio.setEdad(rs.getInt("Edad"));
                socio.setDni(rs.getString("Telefono"));
                socio.setEstado(rs.getBoolean("Estado"));
                return socio;
            }
            
            } catch (SQLException ex) {
            throw new RuntimeException("Error al buscar socio por nombre: " + ex.getMessage());
        }

        return null;
    }
}

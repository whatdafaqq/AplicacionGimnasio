/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Entidades.Entrenador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ramir
 */
public class EntrenadorData {
    
    private Connection conn = null;

    public EntrenadorData() {
        conn = Conexion.getConnection();
    }
    public void agregarEntrenador(Entrenador entrenador) {
    String sql = "INSERT INTO entrenadores (DNI, Nombre, Apellido, Especialidad, Estado) VALUES (?, ?, ?, ?, ?)";
    
    try{
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, entrenador.getDni());
        ps.setString(2, entrenador.getNombre());
        ps.setString(3, entrenador.getApellido());
        ps.setString(4, entrenador.getEspecialidad());
        ps.setBoolean(5, entrenador.isEstado());
        ps.executeUpdate();       
        
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                entrenador.setIdEntrenador(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Entrenador Agregado con exito!");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar un Entrenador" + ex.getMessage(), 
                                      "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public List<Entrenador> listaEntrenadores() {
    List<Entrenador> entrenadores = new ArrayList<>();
    String sql = "SELECT * FROM Entrenadores";
    try (Statement ps = conn.createStatement();
            ResultSet rs = ps.executeQuery(sql)) {
        while (rs.next()) {
            Entrenador entrenador = new Entrenador(
                rs.getInt("ID_Entrenador"),
                rs.getString("DNI"),
                rs.getString("Nombre"),
                rs.getString("Apellido"),
                rs.getString("Especialidad"),
                rs.getBoolean("Estado")
            );
            entrenadores.add(entrenador);
        }
    } catch (SQLException e) {
         JOptionPane.showMessageDialog(null, "Error al visualizar un Entrenador!");
    }
    return entrenadores;
}
    
    public void updateEntrenador(Entrenador entrenador) {
    String sql = "UPDATE Entrenadores SET DNI = ?, Nombre = ?, Apellido = ?, Especialidad = ?, Estado = ? WHERE ID_Entrenador = ?";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, entrenador.getDni());
        ps.setString(2, entrenador.getNombre());
        ps.setString(3, entrenador.getApellido());
        ps.setString(4, entrenador.getEspecialidad());
        ps.setBoolean(5, entrenador.isEstado());
        ps.setInt(6, entrenador.getIdEntrenador());
        ps.executeUpdate();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al actualizar un Entrenador!");
    }
}

    public void deleteEntrenador(int id) {
    String sql = "DELETE FROM Entrenadores WHERE ID_Entrenador = ?";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ps.executeUpdate();
    } catch (SQLException e) {
JOptionPane.showMessageDialog(null, "Error al eliminar un Entrenador!");
    }
}
    
    
    // Método para buscar un entrenador por su ID
    public Entrenador buscarEntrenadorPorId(int id) {
        String sql = "SELECT * FROM entrenador WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Entrenador entrenador = new Entrenador();
                entrenador.setIdEntrenador(rs.getInt("ID_Entrenador"));
                entrenador.setDni(rs.getString("DNI"));
                entrenador.setNombre(rs.getString("nombre"));
                entrenador.setApellido(rs.getString("apellido"));
                entrenador.setEspecialidad(rs.getString("Especialidad"));
                entrenador.setEstado(rs.getBoolean("Estado"));
                return entrenador;
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Error al buscar el entrenador por ID: " + ex.getMessage());
        }

        return null;
    }
    
public List<Entrenador> buscarEntrenadorPorNombre(String nombre) {
        String sql = "select * from entrenadores where Nombre = ?";
         List<Entrenador> lista = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Entrenador entrenador = new Entrenador(
                rs.getInt("ID_Entrenador"),
                rs.getString("DNI"),
                rs.getString("Nombre"),
                rs.getString("Apellido"),         
                rs.getString("Especialidad"),
                rs.getBoolean("Estado"));
                
                lista.add(entrenador);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar visualizar los entrenadores");
            ex.printStackTrace();
        }
        return lista;
        
        
    }
    
    
}

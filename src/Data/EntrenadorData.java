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
    String sql = "INSERT INTO Entrenadores (DNI, Nombre, Apellido, Especialidad, Estado) VALUES (?, ?, ?, ?, ?)";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, entrenador.getDni());
        ps.setString(2, entrenador.getNombre());
        ps.setString(3, entrenador.getApellido());
        ps.setString(4, entrenador.getEspecialidad());
        ps.setBoolean(5, entrenador.isEstado());
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
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
        e.printStackTrace();
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
        e.printStackTrace();
    }
}

    public void deleteEntrenador(int id) {
    String sql = "DELETE FROM Entrenadores WHERE ID_Entrenador = ?";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}



}

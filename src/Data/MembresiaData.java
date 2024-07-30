/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Entidades.Membresia;
import Entidades.Socio;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author ramir
 */
public class MembresiaData {
  private Connection conn = null;

    public MembresiaData() {
        conn = Conexion.getConnection();
    }

     public void agregarMembresia(Membresia m) {
        String sql = "INSERT INTO membresias(ID_Socio, CantidadPases, Fecha_Inicio, Fecha_Fin, Costo, Estado) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, m.getSocio().getIdSocio());
            ps.setInt(2, m.getCantidadPases());
            ps.setDate(3, Date.valueOf(m.getFechaInicio()));
            ps.setDate(4, Date.valueOf(m.getFechaFin()));
            ps.setDouble(5, m.getCosto());
            ps.setBoolean(6, m.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                m.setIdMembresia(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Membresía agregada con éxito!");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar una membresía");
            ex.printStackTrace();
        }
    }

    public List<Membresia> listarMembresias() {
        String sql = "SELECT * FROM membresias";
        List<Membresia> lista = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Socio socio = new Socio(); // Asume que hay una forma de recuperar un socio dado su ID
                socio.setIdSocio(rs.getInt("ID_Socio"));

                Membresia membresia = new Membresia(
                    rs.getInt("ID_Membresia"),
                    socio,
                    rs.getInt("CantidadPases"),
                    rs.getDate("Fecha_Inicio").toLocalDate(),
                    rs.getDate("Fecha_Fin").toLocalDate(),
                    rs.getDouble("Costo"),
                    rs.getBoolean("Estado")
                );
                lista.add(membresia);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar visualizar las membresías");
        }
        return lista;
    }

    public void actualizarMembresia(Membresia m) {
        String sql = "UPDATE membresias SET ID_Socio = ?, CantidadPases = ?, Fecha_Inicio = ?, Fecha_Fin = ?, Costo = ?, Estado = ? WHERE ID_Membresia = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, m.getSocio().getIdSocio());
            ps.setInt(2, m.getCantidadPases());
            ps.setDate(3, Date.valueOf(m.getFechaInicio()));
            ps.setDate(4, Date.valueOf(m.getFechaFin()));
            ps.setDouble(5, m.getCosto());
            ps.setBoolean(6, m.isEstado());
            ps.setInt(7, m.getIdMembresia());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Membresía actualizada con éxito!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la membresía");
        }
    }

    public void eliminarMembresia(int id) {
        String sql = "DELETE FROM membresias WHERE ID_Membresia = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Membresía eliminada con éxito!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la membresía");
        }
    }
    
    public List<Membresia> buscarMembresias(String criterio) {
        List<Membresia> membresias = new ArrayList<>();
        String sql = "SELECT * FROM Membresias WHERE ID_Socio IN (SELECT ID_Socio FROM Socios WHERE Nombre LIKE ?)";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + criterio + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idMembresia = resultSet.getInt("ID_Membresia");
                int idSocio = resultSet.getInt("ID_Socio");
                int cantidadPases = resultSet.getInt("CantidadPases");
                LocalDate fechaInicio = resultSet.getDate("Fecha_Inicio").toLocalDate();
                LocalDate fechaFin = resultSet.getDate("Fecha_Fin").toLocalDate();
                double costo = resultSet.getDouble("Costo");
                boolean estado = resultSet.getBoolean("Estado");

                Socio socio = obtenerSocioPorId(idSocio); // Este método se implementa en SocioData
                Membresia membresia = new Membresia(idMembresia, socio, cantidadPases, fechaInicio, fechaFin, costo, estado);
                membresias.add(membresia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return membresias;
    }
    
    private Socio obtenerSocioPorId(int idSocio) {
        SocioData sd = new SocioData();
        return sd.obtenerSocioPorId(idSocio);
    }
    
    
}


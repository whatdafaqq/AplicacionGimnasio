package Data;

import Entidades.Clase;
import Entidades.Entrenador;
import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClaseData {
    private Connection conn;

    public ClaseData() {
        conn = Conexion.getConnection();
    }

    public void agregarClase(Clase c) {
        String sql = "INSERT INTO clases ( Nombre, ID_Entrenador, Horario, Capacidad, Estado) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, c.getNombre());
            ps.setInt(2, c.getEntrenador().getIdEntrenador());
            ps.setTime(3, Time.valueOf(c.getHorario()));
            ps.setInt(4, c.getCapacidad());
            ps.setBoolean(5, c.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                c.setIdClase(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Clase agregada con éxito!");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar una clase: " + ex.getMessage());
        }
    }

    public List<Clase> listarClases() {
        String sql = "SELECT * FROM clases";
        List<Clase> lista = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Entrenador entrenador = new Entrenador();
                entrenador.setIdEntrenador(rs.getInt("ID_Entrenador"));

                Clase clase = new Clase(
                    rs.getInt("ID_Clase"),
                    rs.getString("Nombre"),
                    entrenador,
                    rs.getTime("Horario").toLocalTime(),
                    rs.getInt("Capacidad"),
                    rs.getBoolean("Estado")
                );
                lista.add(clase);
            }
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar las clases: " + ex.getMessage());
        }
        return lista;
    }

    public void actualizarClase(Clase c) {
        String sql = "UPDATE clases SET ID_Clase = ?, Nombre = ?, ID_Entrenador = ?, Horario = ?, Capacidad = ?, Estado = ? WHERE ID_Clase = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, c.getIdClase());
            ps.setString(2, c.getNombre());
            ps.setInt(3, c.getEntrenador().getIdEntrenador());
            ps.setTime(4, Time.valueOf(c.getHorario()));
            ps.setInt(5, c.getCapacidad());
            ps.setBoolean(6, c.isEstado());
            ps.setInt(7, c.getIdClase());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Clase actualizada con éxito!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la clase: " + ex.getMessage());
        }
    }

    public void eliminarClase(int id) {
        String sql = "DELETE FROM clases WHERE ID_Clase = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Clase eliminada con éxito!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la clase: " + ex.getMessage());
        }
    }
    
     public List<Clase> buscarClases(String searchTerm) {
        List<Clase> clases = new ArrayList<>();
        String sql = "SELECT * FROM clases WHERE Nombre LIKE ? OR ID_Entrenador IN (SELECT ID_Entrenador FROM entrenadores WHERE Nombre LIKE ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + searchTerm + "%");
            ps.setString(2, "%" + searchTerm + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Clase clase = new Clase();
                clase.setIdClase(rs.getInt("ID_Clase"));
                clase.setNombre(rs.getString("Nombre"));
                clase.setEntrenador(new EntrenadorData().buscarEntrenadorPorId(rs.getInt("ID_Entrenador")));
                clase.setHorario(rs.getTime("Horario").toLocalTime());
                clase.setCapacidad(rs.getInt("Capacidad"));
                clase.setEstado(rs.getBoolean("Estado"));
                clases.add(clase);
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Error al buscar clases: " + ex.getMessage());
        }

        return clases;
    }
     
     public void inscribirSocioEnClase(int idSocio, int idClase) {
        String sql = "INSERT INTO socios (idClase, idSocio) VALUES (?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idClase);
            ps.setInt(2, idSocio);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error al inscribir socio en la clase: " + ex.getMessage());
        }
    }


}

/*public List<Clase> buscarClases(String criterio, String valor) throws SQLException {
        List<Clase> clases = new ArrayList<>();
        String sql = "SELECT * FROM Clases WHERE " + criterio + " LIKE ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, "%" + valor + "%");
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int idClase = resultSet.getInt("ID_Clase");
                    String nombre = resultSet.getString("Nombre");
                    int idEntrenador = resultSet.getInt("ID_Entrenador");
                    LocalTime horario = resultSet.getTime("Horario").toLocalTime();
                    int capacidad = resultSet.getInt("Capacidad");
                    boolean estado = resultSet.getBoolean("Estado");

                    EntrenadorData entrenadorData = new EntrenadorData();
                    Entrenador entrenador = entrenadorData.obtenerEntrenador(idEntrenador);

                    Clase clase = new Clase(idClase, nombre, entrenador, horario, capacidad, estado);
                    clases.add(clase);
                }
            }
        }
        return clases;
    }

    public void inscribirSocioEnClase(int idSocio, int idClase) throws SQLException {
        String sql = "INSERT INTO Asistencia (ID_Socio, ID_Clase, Fecha_Asistencia) VALUES (?, ?, CURDATE())";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idSocio);
            statement.setInt(2, idClase);
            statement.executeUpdate();

            String updateMembresia = "UPDATE Membresías SET CantidadPases = CantidadPases - 1 WHERE ID_Socio = ? AND Estado = 1";
            try (PreparedStatement updateStatement = connection.prepareStatement(updateMembresia)) {
                updateStatement.setInt(1, idSocio);
                updateStatement.executeUpdate();
            }
        }
    
    */
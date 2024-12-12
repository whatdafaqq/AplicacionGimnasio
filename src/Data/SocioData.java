/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Entidades.Socio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author ramir
 */
public class SocioData {

    private Connection conn = null;
     private JTable table;

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
            JOptionPane.showMessageDialog(null, "Error al agregar un socio" + ex.getMessage(), 
                                      "Error", JOptionPane.ERROR_MESSAGE);
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
    
    // Método para verificar si una cadena es un número
private boolean isNumeric(String str) {
    try {
        Integer.parseInt(str);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}
    
    public List<Socio> buscarSocios(String nombreORidnombre ) {
        String sql = "select * from socios where Nombre = ? or ID_Socio = ?";
         List<Socio> lista = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
             
        // Verificar si el parámetro 'nombre' es un número (ID) o una cadena
        if (isNumeric(nombreORidnombre)) {
             // Si es numérico, se trata de un ID, entonces lo pasamos como parámetro en el segundo lugar
            ps.setInt(2, Integer.parseInt(nombreORidnombre));
            ps.setString(1, null); // El nombre no se utilizará
            
        }else {
            // Si no es numérico, se trata de un nombre
            ps.setString(1, nombreORidnombre);
            ps.setNull(2, java.sql.Types.INTEGER);  // El ID no se utilizará. 
        }
        
        
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Socio socio = new Socio(
                rs.getInt("ID_Socio"),
                rs.getString("Dni"),
                rs.getString("Nombre"),
                rs.getString("Apellido"),         
                rs.getInt("Edad"),
                rs.getString("Correo"),
                rs.getString("Telefono"),
                rs.getBoolean("Estado"));
                
                lista.add(socio);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar visualizar los socios");
            ex.printStackTrace();
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
        String sql ="delete  from socios where ID_Socio  = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
           ps.setInt(1, id);
             ps.executeUpdate();
        } catch (SQLException ex) {
JOptionPane.showMessageDialog(null, "Error al eliminar un socio");           
ex.printStackTrace();
                }
        
        
    }
    
        public Socio obtenerSocioPorId(int idSocio) {
    Socio socio = null;
    String sql = "SELECT * FROM socios WHERE ID_Socio = ?";
    try {
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, idSocio);
        ResultSet resultSet = statement.executeQuery();
        
        if (resultSet.next()) {
            int id = resultSet.getInt("ID_Socio");
            String dni = resultSet.getString("DNI");
            String nombre = resultSet.getString("Nombre");
            String apellido = resultSet.getString("Apellido");
            int edad = resultSet.getInt("Edad");
            String email = resultSet.getString("Correo");
            String telefono = resultSet.getString("Telefono");
            boolean estado = resultSet.getBoolean("Estado");

            socio = new Socio(id, dni, nombre, apellido, edad, email, telefono, estado);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return socio;
}
        

    
    
}


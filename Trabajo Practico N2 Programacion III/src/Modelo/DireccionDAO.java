package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DireccionDAO {
    private Connection connection;

    public DireccionDAO() {
        this.connection = ConexionMySQL.crearConexion();
    }

    public void insertarDireccion(Direccion direccion, int usuarioID) {
        String sql = "INSERT INTO direcciones(calle, altura, alumno_id) VALUES (?, ?, ?)";

        try(PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, direccion.getCalle());
            pstm.setInt(2, direccion.getAltura());
            pstm.setInt(3, direccion.getId());

            pstm.executeUpdate();
            System.out.println("Direccion ingresada exitosamente. \n");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Direccion> mostrarDireccion() {
        List<Direccion> lista = new ArrayList<>();
        String sql = "SELECT * FROM direcciones";

        try(PreparedStatement pstm = connection.prepareStatement(sql)) {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                String calleAux = rs.getString("calle");
                int alturaAux = rs.getInt("altura");
                String idAux = rs.getString("alumno_id");

                Direccion direccionNueva = new Direccion(calleAux, alturaAux);
                lista.add(direccionNueva);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<Direccion> mostrarDireccionEspecifica(int idBuscado) {
        List<Direccion> lista = new ArrayList<>();
        String sql = "SELECT * FROM direcciones WHERE alumno_id = ?";

        try(PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, idBuscado);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                String calleAux = rs.getString("calle");
                int alturaAux = rs.getInt("altura");

                Direccion direccionNueva = new Direccion(calleAux, alturaAux);
                lista.add(direccionNueva);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void eliminarDirecciones(int id) {
        String sql = "DELETE FROM direcciones WHERE id = ?";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, id);
            int filasAfectadas = pstm.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("¡Direccion eliminada con éxito!");
            } else {
                System.out.println("No se encontró ningúna direccion con el ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar la direccion: " + e.getMessage());
        }
    }
}

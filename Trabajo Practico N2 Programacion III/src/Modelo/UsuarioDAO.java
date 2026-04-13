package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private Connection connection;

    public UsuarioDAO() {
        this.connection = ConexionMySQL.crearConexion();
    }

    public void insertarUsuario(Usuario usuario) {
        String sql = "INSERT INTO alumnos(nombre, apellido, edad, email) VALUES (?, ?, ?, ?)";

        try(PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, usuario.getNombre());
            pstm.setString(2, usuario.getApellido());
            pstm.setInt(3, usuario.getEdad());
            pstm.setString(4, usuario.getEmail());

            pstm.executeUpdate();
            System.out.println("Alumno ingresado exitosamente. \n");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> mostrarUsuario() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM alumnos";

        try(PreparedStatement pstm = connection.prepareStatement(sql)) {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                String nombreAux = rs.getString("nombre");
                String apellidoAux = rs.getString("apellido");
                int edadAux = rs.getInt("edad");
                String emailAux = rs.getString("email");

                Usuario alumnoNuevo = new Usuario(nombreAux, apellidoAux, edadAux, emailAux);
                lista.add(alumnoNuevo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void actualizarEdadUsuario(int id, int nuevaEdad) {
        String sql = "UPDATE alumnos SET edad = ? WHERE id = ?";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, nuevaEdad);
            pstm.setInt(2, id);

            int filasAfectadas = pstm.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("¡Edad actualizada con éxito!");
            } else {
                System.out.println("No se encontró ningún alumno con el ID: " + id);
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar la edad: " + e.getMessage());
        }
    }

    public void eliminarUsuario(int id) {
        String sql = "DELETE FROM alumnos WHERE id = ?";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, id);
            int filasAfectadas = pstm.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("¡Usuario eliminado con éxito!");
            } else {
                System.out.println("No se encontró ningún alumno con el ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el usuario: " + e.getMessage());
        }
    }
}

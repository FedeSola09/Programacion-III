package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioDAO;

import java.util.List;

public class ControladorUsuario {
    private UsuarioDAO dao;

    public ControladorUsuario() {
        this.dao = new UsuarioDAO();
    }

    public void insertar(String nombre, String apellido, int edad, String email) {
        Usuario usuario = new Usuario(nombre, apellido, edad, email);
        dao.insertarUsuario(usuario);
    }

    public List<Usuario> listar() {
        return dao.mostrarUsuario();
    }

    public void actualizarEdadUsuario(int id, int nuevaEdad) {
        dao.actualizarEdadUsuario(id, nuevaEdad);
    }

    public void eliminarUsuario(int id) {
        dao.eliminarUsuario(id);
    }
}

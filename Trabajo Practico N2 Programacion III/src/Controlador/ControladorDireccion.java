package Controlador;

import Modelo.Direccion;
import Modelo.DireccionDAO;
import Modelo.Usuario;

import java.util.List;

public class ControladorDireccion {
    private DireccionDAO dao;

    public ControladorDireccion() {
        this.dao = new DireccionDAO();
    }

    public void insertar(String calle, int altura, int usuarioID) {
        Direccion direc = new Direccion(calle, altura);
        dao.insertarDireccion(direc, usuarioID);
    }

    public List<Direccion> listar() {
        return dao.mostrarDireccion();
    }

    public List<Direccion> listarEspecifico(int idBuscado) {
        return dao.mostrarDireccionEspecifica(idBuscado);
    }

    public void eliminarDirecciones(int id) {
        dao.eliminarDirecciones(id);
    }
}

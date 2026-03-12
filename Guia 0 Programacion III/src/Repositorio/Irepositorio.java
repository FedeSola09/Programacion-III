package Repositorio;

import Exceptions.IdentificadorDuplicadoException;
import Exceptions.ObjectNotFoundException;

import java.util.List;

public interface Irepositorio<T> {
    void agregar(T objeto) throws IdentificadorDuplicadoException;
    void eliminar(T objeto);
    void mostrar();
    void filtrarXGenero(String generoBuscado);
    T buscarPorId(int idAbuscar);
    void modificarAtributo(int id) throws ObjectNotFoundException;
    void switchModificacion(T objeto);
}

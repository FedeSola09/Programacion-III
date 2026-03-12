package Repositorio;

import Exceptions.IdentificadorDuplicadoException;
import Exceptions.ObjectNotFoundException;
import Modelo.Instalable;

import java.io.PrintStream;
import java.util.*;
import java.util.stream.Stream;

public class Coleccion<T extends Instalable> implements Irepositorio<T> {
    private Map<UUID, T> coleccion = new HashMap();

    public Coleccion(Map<UUID, T> coleccion) {
        this.coleccion = coleccion;
    }

    public Coleccion() {

    }

    public Map<UUID, T> getColeccion() {
        return coleccion;
    }

    public void setColeccion(Map<UUID, T> coleccion) {
        this.coleccion = coleccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coleccion<?> coleccion1)) return false;
        return Objects.equals(coleccion, coleccion1.coleccion);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(coleccion);
    }

    @Override
    public String toString() {
        return "Coleccion{" +
                "coleccion=" + coleccion +
                '}';
    }

    @Override
    public void agregar(T objeto) throws IdentificadorDuplicadoException {
        if(this.coleccion.containsKey(objeto.getId())) {
            throw new IdentificadorDuplicadoException("El ID ya existe o no puede agregarse.");
        }
        else {
            this.coleccion.put(objeto.getId(), objeto);
        }
    }

    @Override
    public void eliminar(T objeto) {
        if(this.coleccion.containsKey(objeto.getId())) {
            this.coleccion.remove(objeto.getId());
        }
        else {
            throw new ObjectNotFoundException("El ID no fue encontrado.");
        }
    }

    public void mostrar() {
        ArrayList<T> lista = new ArrayList();
        this.coleccion.forEach((clave, valor) -> {
            lista.add(valor);
        });
        Stream var10000 = lista.stream().sorted();
        PrintStream var10001 = System.out;
        Objects.requireNonNull(var10001);
        var10000.forEach(var10001::println);
    }

    public void filtrarXGenero(String generoBuscado) {
        this.coleccion.forEach((clave, valor) -> {
            if (valor.getGenero().equals(generoBuscado)) {
                System.out.println(valor);
            }

        });
    }

    @Override
    public T buscarPorId(int idAbuscar) {
        return this.coleccion.get(idAbuscar);
    }

    @Override
    public void modificarAtributo(int id) throws ObjectNotFoundException {
        T aux = this.buscarPorId(id);
        if (aux != null) {
            this.switchModificacion(aux);
        } else {
            throw new ObjectNotFoundException("El ID indicado no existe en la lista.");
        }
    }

    @Override
    public void switchModificacion(T objeto) {

    }


}

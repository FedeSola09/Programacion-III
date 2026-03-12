package Modelo;

import Exceptions.IdentificadorDuplicadoException;

import java.util.Objects;
import java.util.UUID;

public abstract class Instalable implements Imedia, Comparable<Instalable> {
    private String titulo;
    private String creador;
    private String genero;
    private UUID id = UUID.randomUUID();

    public Instalable(String titulo, String creador, String genero, UUID id) {
        this.titulo = titulo;
        this.creador = creador;
        this.genero = genero;
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Instalable that)) return false;
        return Objects.equals(titulo, that.titulo) && Objects.equals(creador, that.creador) && Objects.equals(genero, that.genero) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, creador, genero, id);
    }

    @Override
    public String toString() {
        return "Modelo.Instalable{" +
                "titulo='" + titulo + '\'' +
                ", creador='" + creador + '\'' +
                ", genero='" + genero + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public int compareTo(Instalable o) {
        return this.id.compareTo(o.getId());
    }
}

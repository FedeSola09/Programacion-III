package Modelo;

import java.util.UUID;

public class Juego extends Instalable {
    private Integer version;

    public Juego(String titulo, String creador, String genero, UUID id, Integer version) {
        super(titulo, creador, genero, id);
        this.version = version;
    }

    public Juego(String tit, String gen, String cre, String ver) {
        super(tit, gen, cre, UUID.fromString(ver));
    }

    public String buscarPorId(int idAbuscar) {

        return null;
    }

    public String buscarPorGenero(String generoAbuscar) {
        return null;
    }

    public boolean verificarVersion(int numVersion) {
        return numVersion >= 0;
    }

    @Override
    public String toString() {
        return "Juego" +
                "{" +
                "version=" + this.version +
                ", id=" + this.getId() +
                ", titulo='" + this.getTitulo() +
                "', genero='" + this.getGenero() +
                "', creador='" + this.getCreador() + "" +
                "'}";
    }
}

package Modelo;

import java.util.Objects;
import java.util.UUID;

public class DLC extends Instalable {
    String fechaLanzamiento;

    public DLC(String titulo, String creador, String genero, UUID id, String fechaLanzamiento) {
        super(titulo, creador, genero, id);
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public DLC(String tit, String gen, String cre, String fdl) {
        super(tit, gen, cre, UUID.fromString(fdl));
    }

    public String buscarPorId(int idAbuscar) {
        return null;
    }

    public String buscarPorGenero(String generoAbuscar) {
        return null;
    }

    public boolean verificarFecha(String fecha) {
        return !fecha.equals("");
    }

    @Override
    public String toString() {
        return "DLC{" +
                "fechaLanzamiento='" + fechaLanzamiento + '\'' +
                ", id=" + this.getId() +
                ", titulo='" + this.getTitulo() +
                "', genero='" + this.getGenero() +
                "', creador='" + this.getCreador() + "" +
                "'}";
    }
}

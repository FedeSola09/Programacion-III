package Modelo;

import java.util.UUID;

public class Direccion {
    private int contador = 0;
    private int id = contador++;
    private String calle;
    private int altura;

    public Direccion(String calle, int altura) {
        this.id = contador++;
        this.calle = calle;
        this.altura = altura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}

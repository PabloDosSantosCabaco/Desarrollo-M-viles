package com.example.recycleviewtest;

public class SistemaOperativo {
    String nombre, año;
    int logo;

    public SistemaOperativo(String nombre, String año, int logo) {
        this.nombre = nombre;
        this.año = año;
        this.logo = logo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }
}

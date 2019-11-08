package com.example.libros;

public class Libro {
    String nombre, autor;
    int numPaginas, portada;
    float valoracion;

    public Libro(String nombre, String autor, int numPaginas, float valoracion, int portada) {
        this.nombre = nombre;
        this.autor = autor;
        this.numPaginas = numPaginas;
        this.portada = portada;
        this.valoracion = valoracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public int getPortada() {
        return portada;
    }

    public void setPortada(int portada) {
        this.portada = portada;
    }

    public float getValoracion() {
        return valoracion;
    }

    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }
}

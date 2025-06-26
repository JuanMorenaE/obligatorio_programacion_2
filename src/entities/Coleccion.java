package entities;

import TADs.LinkedList.LinkedList;
import TADs.List.List;

public class Coleccion implements Comparable<Coleccion> {

    private int id;
    private String nombre;
    private int CantidadPeliculas;
    private LinkedList<Pelicula> peliculas;
    private long ingresos;

    public Coleccion(int id, String nombre) {
        this.peliculas= new LinkedList<Pelicula>();
        this.id = id;
        this.nombre = nombre;
        this.CantidadPeliculas = 0;
        this.ingresos = 0;
    }

    public void insertarPeliculas(Pelicula p) {
        peliculas.add(p);
        CantidadPeliculas++;
        this.ingresos+= p.getRevenue();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadPeliculas() {
        return CantidadPeliculas;
    }

    public void setCantidadPeliculas(int cantidadPeliculas) {
        CantidadPeliculas = cantidadPeliculas;
    }

    public LinkedList<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(LinkedList<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public long getIngresos() {
        return ingresos;
    }

    public void setIngresos(long ingresos) {
        this.ingresos = ingresos;
    }

    @Override
    public int compareTo(Coleccion o) {
        return Long.compare(getIngresos(), o.getIngresos());
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        string.append("[");

        for (int i = 0; i < peliculas.getSize() - 1; i++)
            string.append(peliculas.get(i).getId()).append(", ");

        string.append(peliculas.get(peliculas.getSize() - 1).getId()).append("]");

        return string.toString();
    }
}

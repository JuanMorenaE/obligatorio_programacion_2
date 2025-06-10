package entities;

import TADs.LinkedList.LinkedList;
import TADs.List.List;

public class Coleccion implements Comparable<Coleccion> {
    private int id;
    private String nombre;
    private int CantidadPeliculas;
    private LinkedList<Pelicula> peliculas;
    private int ingresos;

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

    public LinkedList getPeliculas() {
        return peliculas;
    }

    public int getCantidadPeliculas() {
        return CantidadPeliculas;
    }


    public int getIngresos() {
        return ingresos;
    }


    public int getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }


    @Override
    public int compareTo(Coleccion o) {
        if(o.getIngresos() < this.getIngresos()) {
            return 1;
        }
        if(o.getIngresos() > this.getIngresos()) {
            return -1;
        }
        return 0;
    }
}

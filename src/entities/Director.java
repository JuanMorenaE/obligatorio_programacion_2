package entities;

public class Director {
    private int idDirector;
    private String nombre;
    private int calificaciones;
    private int cantidadCalificaciones;
    private int cantidadPeliculas;


    public Director(int idDirector, String nombre) {

        this.idDirector = idDirector;
        this.nombre = nombre;
        this.calificaciones = 0;
        this.cantidadPeliculas = 0;

    }
    public int getIdDirector() {
        return idDirector;
    }

    public String getNombre() {
        return nombre;
    }
    public void agregarCalificacion(int calificacion) {
        cantidadCalificaciones++;
        calificacion = (calificaciones*cantidadCalificaciones + calificacion)/cantidadCalificaciones;
    }

    public int getCantidadCalificaciones() {
        return cantidadCalificaciones;
    }

    public void agregarPelicula() {
        cantidadPeliculas++;
    }


}

package entities;

public class Director implements Comparable<Director> {
    private int id;
    private String nombre;
    private int calificaciones;
    private int cantidadCalificaciones;
    private int cantidadPeliculas;


    public Director(int idDirector, String nombre) {

        this.id = idDirector;
        this.nombre = nombre;
        this.calificaciones = 0;
        this.cantidadPeliculas = 0;

    }
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    public void agregarCalificacion(float calificacion) {
        cantidadCalificaciones++;
        calificacion = (calificaciones*cantidadCalificaciones + calificacion)/cantidadCalificaciones;
    }

    public int getCantidadCalificaciones() {
        return cantidadCalificaciones;
    }

    public void agregarPelicula() {
        cantidadPeliculas++;
    }

    public void setIdDirector(int idDirector) {
        this.id = idDirector;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(int calificaciones) {
        this.calificaciones = calificaciones;
    }

    public void setCantidadCalificaciones(int cantidadCalificaciones) {
        this.cantidadCalificaciones = cantidadCalificaciones;
    }

    public int getCantidadPeliculas() {
        return cantidadPeliculas;
    }

    public void setCantidadPeliculas(int cantidadPeliculas) {
        this.cantidadPeliculas = cantidadPeliculas;
    }

    @Override
    public int compareTo(Director o) {
        return Integer.compare(getId(), o.getId());
    }
}

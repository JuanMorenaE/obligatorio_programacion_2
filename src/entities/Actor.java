package entities;

public class Actor implements Comparable<Actor> {
    private int id;
    private String nombre;
    private int calificaciones;
    private int cantidadCalificaciones;

    private int[] calificacionesMes;
    private int[] peliculasMes;

    public Actor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.calificaciones = 0;
        this.cantidadCalificaciones = 0;
        this.calificacionesMes = new int[12];
        this.peliculasMes = new int[12];
    }

    public int getId() {return id;}
    public String getNombre() {return nombre;}
    public int getCalificacion() {return calificaciones;}
    public int[] getVisitasMes() {return calificacionesMes;}
    public int getCantidadCalificacion() {return cantidadCalificaciones;}
    public int[] getPeliculasMes() {return peliculasMes;}


    public void agregarCalificacion(float calificacion) {
        cantidadCalificaciones++;
        calificacion = (calificaciones*cantidadCalificaciones + calificacion)/cantidadCalificaciones;
    }

    public void visitasMes(int[] calificacionesMesPelicula) {

        for (int i = 0; i < 12; i++) {
            if (calificacionesMesPelicula[i] != 0) {
                peliculasMes[i]++;
                calificacionesMes[i]+= calificacionesMesPelicula[i];
            }
        }
    }

    public void setId(int id) {
        this.id = id;
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

    public int getCantidadCalificaciones() {
        return cantidadCalificaciones;
    }

    public void setCantidadCalificaciones(int cantidadCalificaciones) {
        this.cantidadCalificaciones = cantidadCalificaciones;
    }

    public int[] getCalificacionesMes() {
        return calificacionesMes;
    }

    public void setCalificacionesMes(int[] calificacionesMes) {
        this.calificacionesMes = calificacionesMes;
    }

    public void setPeliculasMes(int[] peliculasMes) {
        this.peliculasMes = peliculasMes;
    }


    @Override
    public int compareTo(Actor o) {
        return Integer.compare(getId(), o.getId());
    }
}

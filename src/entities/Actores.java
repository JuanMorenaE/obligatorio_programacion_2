package entities;

public class Actores implements Comparable<Actores> {
    private int id;
    private String nombre;
    private int calificaciones;
    private int cantidadCalificaciones;
    private int[] calificacionesMes;
    private int[] peliculasMes;

    public Actores(int id, String nombre) {
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


    public void agregarCalificacion(int calificacion) {
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


    @Override
    public int compareTo(Actores o) {
        if (id > o.id) {
            return 1;
        }
        if (id < o.id) {
            return -1;
        }
        return 0;
    }
}

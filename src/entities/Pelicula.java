package entities;

import TADs.LinkedList.LinkedList;

import java.time.LocalDate;
import java.util.ArrayList;


public class Pelicula implements Comparable<Pelicula>{
    private int id;
    private long budget;
    private ArrayList<Integer> generos;
    private String original_language;
    private String original_title;
    private LocalDate release_date;
    private long revenue;
    private float calificacion;
    private int cantidadCalificaciones;
    private Director director;
    private LinkedList<Actor> actores;
    private int[] calificacionesMes;
    private int collectionId;
    private String collectionName;


    public Pelicula(int id, long budget, ArrayList<Integer> generos, String original_language, String original_title, LocalDate release_date, long revenue, int collectionId, String collectionName) {
        this.id = id;
        this.budget = budget;
        this.generos = generos;
        this.original_language = original_language;
        this.original_title = original_title;
        this.release_date = release_date;
        this.revenue = revenue;
        this.cantidadCalificaciones = 0;
        this.calificacion = 0;
        this.director = null;
        this.actores = new LinkedList<>();
        this.calificacionesMes = new int[12];
        this.collectionId = collectionId;
        this.collectionName = collectionName;

    }


    public int getId() {return id;}
    public long getBudget() {return budget;}
    public ArrayList<Integer> getGeneros() {return generos;}
    public String getOriginal_language() {return original_language;}
    public String getOriginal_title() {return original_title;}
    public LocalDate getRelease_date() {return release_date;}
    public long getRevenue() {return revenue;}
    public float getCalificacion() {return calificacion;}
    public int getCantidadCalificaciones() {return cantidadCalificaciones;}
    public Director getDirector() {return director;}
    public LinkedList<Actor> getActores() {return actores;}
    public int[] getCalificacionesMes() {return calificacionesMes;}
    public int getCollectionId() {return collectionId;}
    public String getCollectionName() {return collectionName;}

    public void agregarCalificacion(float calificacion1, LocalDate fecha) {

        //promedio calificaciones
        cantidadCalificaciones++;
        this.calificacion = (this.calificacion * (cantidadCalificaciones-1) + calificacion1)/ cantidadCalificaciones;

        //Sumo una califacion al mes

        int mes= fecha.getMonthValue()-1;
        calificacionesMes[mes]++;

    }

    public void setDirector(Director director) {
        //seteo director
        this.director = director;
    }

    public void agregarActor(Actor actor) {
        if (cantidadCalificaciones != 0) {
            actor.agregarCalificacion(calificacion);
        }
        actor.visitasMes(calificacionesMes);
        actores.add(actor);
    }

    public void agregarDirector(Director directorNew) {
        if (cantidadCalificaciones != 0) {
            directorNew.agregarCalificacion(calificacion);
        }

        directorNew.agregarPelicula();
        setDirector(directorNew);
    }


    @Override
    public int compareTo(Pelicula o) {
        return Integer.compare(getId(), o.getId());
    }
}
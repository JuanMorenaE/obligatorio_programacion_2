package entities;

import TADs.LinkedList.LinkedList;

import java.time.LocalDate;
import java.util.ArrayList;


public class Pelicula implements Comparable<Pelicula>{
    private int id;
    private long budget;
    private ArrayList<Integer> generos;
    private String originalLanguage;
    private String originalTitle;
    private LocalDate releaseDate;
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
        this.originalLanguage = original_language;
        this.originalTitle = original_title;
        this.releaseDate = release_date;
        this.revenue = revenue;
        this.cantidadCalificaciones = 0;
        this.calificacion = 0;
        this.director = null;
        this.actores = new LinkedList<>();
        this.calificacionesMes = new int[12];
        this.collectionId = collectionId;
        this.collectionName = collectionName;

    }

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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public ArrayList<Integer> getGeneros() {
        return generos;
    }

    public void setGeneros(ArrayList<Integer> generos) {
        this.generos = generos;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public long getRevenue() {
        return revenue;
    }

    public void setRevenue(long revenue) {
        this.revenue = revenue;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public int getCantidadCalificaciones() {
        return cantidadCalificaciones;
    }

    public void setCantidadCalificaciones(int cantidadCalificaciones) {
        this.cantidadCalificaciones = cantidadCalificaciones;
    }

    public Director getDirector() {
        return director;
    }

    public LinkedList<Actor> getActores() {
        return actores;
    }

    public void setActores(LinkedList<Actor> actores) {
        this.actores = actores;
    }

    public int[] getCalificacionesMes() {
        return calificacionesMes;
    }

    public void setCalificacionesMes(int[] calificacionesMes) {
        this.calificacionesMes = calificacionesMes;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    @Override
    public int compareTo(Pelicula o) {
        return Integer.compare(getId(), o.getId());
    }
}
package entities;

import TADs.LinkedList.LinkedList;

import java.util.Date;

public class Pelicula {
    private int id;
    private int budget;
    private LinkedList<Generos> generos;
    private String original_language;
    private String original_title;
    private Date release_date;
    private int revenue;
    private int calificacion;
    private int cantidadCalificaciones;
    private Director director;
    private LinkedList<Actores> actores;
    private int[] calificacionesMes;


    public Pelicula(int id, int budget, LinkedList<Generos> generos, String original_language, String original_title, Date release_date, int revenue) {
        this.id = id;
        this.budget = budget;
        this.generos = generos;
        this.original_language = original_language;
        this.original_title = original_title;
        this.release_date = release_date;
        this.revenue = revenue;
        this.generos = generos;
        this.cantidadCalificaciones = 0;
        this.calificacion = 0;
        this.director = null;
        this.actores = new LinkedList<>();
        this.calificacionesMes = new int[12];

    }


    public int getId() {return id;}
    public int getBudget() {return budget;}
    public LinkedList<Generos> getGeneros() {return generos;}
    public String getOriginal_language() {return original_language;}
    public String getOriginal_title() {return original_title;}
    public Date getRelease_date() {return release_date;}
    public int getRevenue() {return revenue;}

    public void agregarCalificacion(int calificacion, Date fecha) {

        //promedio calificaciones
        cantidadCalificaciones++;
        this.calificacion = (this.calificacion * cantidadCalificaciones + calificacion)/ cantidadCalificaciones;

        //Sumo una califacion al mes

        int mes= fecha.getMonth();
        calificacionesMes[mes]++;

    }

    public void setDirector(Director director) {
        //seteo director
        this.director = director;
    }

    public void agregarActor(Actores actor) {
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







}
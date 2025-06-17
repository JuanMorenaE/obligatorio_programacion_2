package utils;

import TADs.exceptions.ElementoYaExisteException;
import entities.Genero;
import entities.Pelicula;
import entities.Rating;
import entities.UMovie;
import org.apache.commons.lang3.NotImplementedException;

import java.time.LocalDate;
import java.util.ArrayList;

public class DataBuilder {
    public static void AddMovie(int id, int collectionId, String collectionName, long budget, String language, String title, LocalDate releaseDate, long revenue, ArrayList<Integer> genres){
        try{
            Pelicula pelicula = new Pelicula(id,budget, null, language, title, releaseDate, revenue, collectionId, collectionName);//va si generos
            UMovie.insertarPeliculas(pelicula);
        }catch(ElementoYaExisteException _){

        }

    }

    public static void AddActor(int movieId, int actorId, String actorName){
        throw new NotImplementedException();
    }

    public static void AddDirector(int movieId, int directorId, String directorName){
        throw new NotImplementedException();
    }

    public static void AddGenre(int id, String name){
        try{
            Genero genre = new Genero(id, name);
            UMovie.generos.add(genre.getId(), genre);
        }catch(ElementoYaExisteException _){

        }
    }

    public static void AddRating(int userId, int movieId, float rating, LocalDate date){
        Rating r = new Rating(userId, movieId, rating, date);
        throw new NotImplementedException();
    }
}

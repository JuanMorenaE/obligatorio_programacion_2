package utils;

import entities.Pelicula;
import entities.Ratings;
import entities.UMovie;

import java.time.LocalDate;

public class DataBuilder {
    public static void AddMovie(int id, int collectionId, String collectionName, int budget, String language, String title, LocalDate releaseDate, int revenue){
        Pelicula p = new Pelicula(id,budget, null, language, title, releaseDate, revenue, collectionId, collectionName);//va si generos
        UMovie.insertarPeliculas(p);

    }

    // TODO.
    public static void AddCredits(){

    }

    public static void AddRating(int userId, int movieId, int rating, LocalDate date){
        Ratings r= new Ratings(userId, movieId, rating, date);
    }
}

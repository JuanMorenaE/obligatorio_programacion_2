package entities;

import TADs.Hash.HashLinear;
import TADs.LinkedList.LinkedList;

import java.util.ArrayList;

public class UMovie {
    public static HashLinear<Integer, Pelicula> peliculas =new HashLinear<>(45000);
    public static HashLinear<Integer, Coleccion> colecciones = new HashLinear<>(10000);
    public static HashLinear<Integer, Actor> actores = new HashLinear<>(10000);
    public static HashLinear<Integer, Director> directores = new HashLinear<>(10000);
    public static HashLinear<Integer, Usuario> usuarios = new HashLinear<>(10000);
    public static HashLinear<Integer, Genero> generos = new HashLinear<>(20);

    public static Usuario buscarUsuario(int id){
        return usuarios.get(id);
    }

    public static Actor buscarActor(int id){
        return actores.get(id);
    }

    public static Genero buscarGenero(int id){
        return generos.get(id);
    }

    public static void  insertarPeliculas(Pelicula pelicula) {
        Coleccion collection;
        if (pelicula.getCollectionId() != -1) { //pertenece a una coleccion
            collection = colecciones.get(pelicula.getCollectionId());

            if (collection != null)  //la coleccion esta en la lista de colecciones
                collection.insertarPeliculas(pelicula);
            else{
                collection = new Coleccion(pelicula.getCollectionId(), pelicula.getCollectionName());  //la coleccion no esta en la lista de colecciones
                collection.insertarPeliculas(pelicula);
                colecciones.add(pelicula.getCollectionId(), collection);
            }
        }
        else{ //pelicula individual
            collection = new Coleccion(pelicula.getId(), pelicula.getOriginal_title());
            collection.insertarPeliculas(pelicula);
            colecciones.add(pelicula.getId(), collection);
        }
        peliculas.add(pelicula.getId(), pelicula);
    }


    public static void insertarActores(int movieId, int actorId, String actorName) {
        Actor actor = buscarActor(actorId);

        if (actor == null) {
            actor = new Actor(actorId, actorName);
            actores.add(actor.getId(), actor);
        }

        Pelicula pelicula= peliculas.get(movieId);

        if (pelicula == null)
            return;

        pelicula.agregarActor(actor);
    }

    public static void insertarDirector(Director director,Integer movieid) {
        Director director1 = directores.get(director.getId());

        if (director1 == null) {
            directores.add(director.getId(), director);
            director1 = directores.get(director.getId());
        }

        Pelicula pelicula= peliculas.get(movieid);
        if (pelicula == null) {
            return;
        }
        pelicula.agregarDirector(director1);


    }



    public static void insertarRaiting(Rating rating){

        int movieId = rating.getMovieId();
        Pelicula pelicula = peliculas.get(movieId);

        if(pelicula == null)
            return;

        int userId = rating.getUserId();
        Usuario usuario = buscarUsuario(userId);

        if (usuario == null){
            usuario = new Usuario(userId);
            usuarios.add(userId, usuario);
        }


        pelicula.agregarCalificacion(rating.getRating(), rating.getDate());
        ArrayList<Integer> generosPelicula = pelicula.getGeneros();

        for (int i = 0; i < generosPelicula.size(); i++) {
            Integer generoid = generosPelicula.get(i);
            Genero genero = generos.get(generoid);
            if(usuario.getGeneroVisto(genero.getId()) == null){
                genero.setVisitas(0);
                usuario.agregarGenero(genero);
            }
            usuario.agregarVisita(genero.getId());
            Genero generoGeneral = buscarGenero(genero.getId());
            generoGeneral.agregarVisita();
        }
    }

}

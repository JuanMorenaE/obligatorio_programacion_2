package entities;

import TADs.Hash.HashLinear;
import TADs.LinkedList.LinkedList;

public class UMovie {
    public static HashLinear<Integer, Pelicula> peliculas =new HashLinear<>(45000);
    public static HashLinear<Integer, Coleccion> colecciones = new HashLinear<>(10000);
    public static HashLinear<Integer, Actor> actores = new HashLinear<>(10000);
    public static HashLinear<Integer, Director> directores = new HashLinear<>(10000);
    public static HashLinear<Integer, Rating> ratings = new HashLinear<>(10000);
    public static HashLinear<Integer, Usuario> usuarios = new HashLinear<>(10000);
    public static HashLinear<Integer, Genero> generos = new HashLinear<>(20);

    public static Usuario buscarUsuario(int id){
        return usuarios.get(id);
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
    }

    public static void insertarRaiting(Rating rating){
        int userId = rating.getUserId();
        Usuario usuario = buscarUsuario(userId);

        if (usuario == null){
            usuario = new Usuario(userId);
            usuarios.add(userId, usuario);
        }

        int peliculaId = rating.getFilmId();
        Pelicula pelicula = peliculas.get(peliculaId);
        pelicula.agregarCalificacion(rating.getRating(), rating.getDate());
        LinkedList<Genero> generosPelicula = pelicula.getGeneros();

        for (int i = 0; i < generosPelicula.getSize(); i++) {
            Genero genero = generosPelicula.get(i);
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

package entities;

import TADs.Hash.HashLinear;
import TADs.Hash.HashLinkedList;
import TADs.Hash.HashTree;
import TADs.Heap.Heap;
import TADs.LinkedList.LinkedList;

import java.util.Hashtable;

public class UMovie {
    public static HashLinear<Integer, Pelicula> peliculas=new HashLinear(10000);
    public static HashLinear<Integer, Coleccion> colecciones= new HashLinear(10000);
    public static HashLinear actores= new HashLinear(10000);
    public static HashLinear directores= new HashLinear(10000);
    public static HashLinear ratings= new HashLinear(10000);
    public static HashLinear<Integer, Usuario> usuarios= new HashLinear(10000);
    public static HashLinear<Integer, Generos> generos= new HashLinear(10000);

    public static Usuario buscarUsuario(int id){
        Usuario u= usuarios.get(id);
        return u;
    }

    public static Generos buscarGenero(int id){
        Generos g= generos.get(id);
        return g;
    }

    public static void  insertarPeliculas(Pelicula p) {
        Coleccion c;
        if (p.getCollectionId() != -1) { //pertenece a una coleccion

            c= colecciones.get(p.getCollectionId());
            if (c!= null){  //la coleccion esta en la lista de colecciones
             c.insertarPeliculas(p);
            }

            else{
             c= new Coleccion(p.getCollectionId(), p.getCollectionName());  //la coleccion no esta en la lista de colecciones
             c.insertarPeliculas(p);
             colecciones.add(p.getCollectionId(), c);
}
        }
        else{ //pelicula individual
            c= new Coleccion(p.getId(), p.getOriginal_title());
            c.insertarPeliculas(p);
            colecciones.add(p.getId(), c);
        }
    }



    public static void consulta1(Pelicula p){
        String idioma= p.getOriginal_language();

    }

    public static void insertar_raiting(Ratings r){
        int IdUsuario= r.getUserId();
        Usuario u= buscarUsuario(IdUsuario);

        if (u == null){
            Usuario uNew= new Usuario(IdUsuario);
            usuarios.add(IdUsuario, uNew);
        }

        int IdPelicula= r.getFilmId();
        Pelicula p= peliculas.get(IdPelicula);
        p.agregarCalificacion(r.getRating(),r.getDate());
        LinkedList<Generos> generosPelicula= p.getGeneros();

        for (int i = 0; i < generosPelicula.getSize(); i++) {
            Generos g= generosPelicula.get(i);
            if(u.getGeneroVisto(g.getId())== null){
                g.setVisitas(0);
                u.agregarGenero(g);
            }
            u.agregarVisita(g.getId());
            Generos generoGeneral= buscarGenero(g.getId());
            generoGeneral.agregarVisita();

        }


    }


}

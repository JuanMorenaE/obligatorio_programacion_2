package entities;

import TADs.Hash.HashLinear;
import TADs.Hash.HashLinkedList;
import TADs.Hash.HashTree;
import TADs.LinkedList.LinkedList;

import java.util.Hashtable;

public class UMovie {
    public static HashLinear peliculas=new HashLinear(10000);
    public static HashLinear colecciones= new HashLinear(10000);
    public static HashLinear actores= new HashLinear(10000);
    public static HashLinear directores= new HashLinear(10000);
    public static HashLinear ratings= new HashLinear(10000);
    public static HashLinear usuarios= new HashLinear(10000);
    public static HashLinear generos= new HashLinear(10000);
    public static LinkedList<Coleccion> tres=  new LinkedList();

    public static void  insertarPeliculas(Pelicula p) {
        Coleccion c;
        if (p.getCollectionId() != -1) { //pertenece a una coleccion
         if (colecciones.pertenece(Integer.toString(p.getCollectionId()))){  //la coleccion esta en la lista de colecciones
             colecciones.get().insertarPeliculas(p);
             c= colecciones.get();
         }
         else{
             c= new Coleccion(p.getCollectionId(), p.getCollectionName());  //la coleccion no esta en la lista de colecciones
             c.insertarPeliculas(p);
             colecciones.insertar(Integer.toString(p.getCollectionId()), c);
         }
        }
        else{ //pelicula individual
            c= new Coleccion(p.getId(), p.getOriginal_title());
            c.insertarPeliculas(p);
            colecciones.insertar(Integer.toString(p.getId()), c);
        }
        //ejercicio 3

        int ingresos= c.getIngresos();

        peliculas.insertar(Integer.toString(p.getId()), p);
        if(tres.getSize()>=10){
            if (ingresos> tres.get(10).getIngresos()){
                tres.addInOrder(colecciones.get());
            }
        }
        else {
            tres.addInOrder(colecciones.get());
        }


    }


}

package entities;

import TADs.Hash.HashLinear;
import TADs.Hash.HashLinkedList;
import TADs.Hash.HashTree;

import java.util.Hashtable;

public class UMovie {
    public static HashLinear pelicula=new HashLinear(10000);
    public static HashLinear colecciones= new HashLinear(10000);
    public static HashLinear actores= new HashLinear(10000);
    public static HashLinear directores= new HashLinear(10000);
    public static HashLinear ratings= new HashLinear(10000);
    public static HashLinear usuarios= new HashLinear(10000);
    public static HashLinear generos= new HashLinear(10000);


    public static void  insertarPeliculas(Pelicula p) {
        if (p.getCollectionId() != -1) {

        }
    }


}

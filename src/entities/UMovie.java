package entities;

import TADs.Hash.HashLinear;
import TADs.Hash.HashLinkedList;
import TADs.Hash.HashTree;
import TADs.LinkedList.LinkedList;

import java.util.Hashtable;

public class UMovie {
    public static HashLinear<Integer, Pelicula> peliculas=new HashLinear(10000);
    public static HashLinear<Integer, Coleccion> colecciones= new HashLinear(10000);
    public static HashLinear actores= new HashLinear(10000);
    public static HashLinear directores= new HashLinear(10000);
    public static HashLinear ratings= new HashLinear(10000);
    public static HashLinear usuarios= new HashLinear(10000);
    public static HashLinear generos= new HashLinear(10000);
    public static LinkedList<Coleccion> tres=  new LinkedList();

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
        //ejercicio 3

        int ingresos= c.getIngresos();
        peliculas.add(p.getId(), p);
        if(tres.getSize()>=10){
            if (ingresos> tres.get(9).getIngresos()){
                tres.addInOrder(c);
            }
        }
        else {
            tres.addInOrder(c);
        }
    }

    public void Consulta3(){
        Coleccion c;
        for (int i = 0; i < 10; i++) {
            c= colecciones.get(i);
            System.out.println(c.getId()+", "+c.getNombre()+", "+c.getCantidadPeliculas()+", "+c.getPeliculas()+", "+c.getIngresos());
        }

    }


}

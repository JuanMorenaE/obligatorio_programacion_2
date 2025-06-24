package entities;

import TADs.Hash.*;
import TADs.Queue.PriorityQueue;
import interfaces.IConsultas;

import java.util.ArrayList;

import static entities.UMovie.peliculas;

public class Consultas implements IConsultas {


    @Override
    public void Top5PeliculasPorIdiomaMasCalificadas() {

//        for(HashItem<Integer,Coleccion> hashPelicula: UMovie.colecciones.getHashmap()){
//            Pelicula pelicula = hashPelicula.getValue();
//            String idioma= pelicula.getOriginal_language();
//
//            long ingresos= c.getIngresos();
//            peliculas.add(p.getId(), p);
//            if(tres.getSize()>=10){
//                if (ingresos> tres.get(9).getIngresos()){
//                    tres.addInOrder(c);
//                }
//            }
//            else {
//                tres.addInOrder(c);
//            }
//        }


        PriorityQueue<Pelicula> peliculasConsult = new PriorityQueue<>();
        PriorityQueue<Pelicula> peliculasConsultesp = new PriorityQueue<>();
        PriorityQueue<Pelicula> peliculasConsulting = new PriorityQueue<>();
        PriorityQueue<Pelicula> peliculasConsultfra = new PriorityQueue<>();
        PriorityQueue<Pelicula> peliculasConsultita = new PriorityQueue<>();
        PriorityQueue<Pelicula> peliculasConsultpor = new PriorityQueue<>();

        for(HashItem<Integer,Pelicula> item: peliculas.getHashmap()){
            Pelicula pelicula = item.getValue();
            String idioma= pelicula.getOriginal_language();
            if (peliculasConsult.isEmpty()) {
                peliculasConsult.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                switch(idioma){
                    case "English":
                        peliculasConsulting.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                    case "Spanish":
                        peliculasConsultesp.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                    case "French":
                        peliculasConsultfra.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                    case "Italian":
                        peliculasConsultita.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                    case "Portuguese":
                        peliculasConsultpor.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                }
                break;
            }
            if(peliculasConsult.size()<5){
                switch(idioma){
                    case "English":
                        peliculasConsulting.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                    case "Spanish":
                        peliculasConsultesp.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                    case "French":
                        peliculasConsultfra.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                    case "Italian":
                        peliculasConsultita.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                    case "Portuguese":
                        peliculasConsultpor.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                }
                break;
            }
            if (peliculasConsult.getLast().getCantidadCalificaciones() < pelicula.getCantidadCalificaciones()) {
                switch(idioma){
                    case "English":
                        peliculasConsulting.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                    case "Spanish":
                        peliculasConsultesp.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                    case "French":
                        peliculasConsultfra.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                    case "Italian":
                        peliculasConsultita.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                    case "Portuguese":
                        peliculasConsultpor.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                }
                break;
            }

        }
        //Print Ingles
        System.out.println("Ingles");
        for (int i = 0; i < 5; i++) {
            Pelicula pelicula = peliculasConsulting.dequeue();
            System.out.println(pelicula.getId()+", "+pelicula.getOriginal_title()+", "+pelicula.getCantidadCalificaciones()+", "+pelicula.getOriginal_language());

        }
        System.out.println("Esp");
        for (int i = 0; i < 5; i++) {
            Pelicula pelicula = peliculasConsultesp.dequeue();
            System.out.println(pelicula.getId()+", "+pelicula.getOriginal_title()+", "+pelicula.getCantidadCalificaciones()+", "+pelicula.getOriginal_language());

        }
        System.out.println("fre");
        for (int i = 0; i < 5; i++) {
            Pelicula pelicula = peliculasConsultfra.dequeue();
            System.out.println(pelicula.getId()+", "+pelicula.getOriginal_title()+", "+pelicula.getCantidadCalificaciones()+", "+pelicula.getOriginal_language());

        }
        System.out.println("it");
        for (int i = 0; i < 5; i++) {
            Pelicula pelicula = peliculasConsultita.dequeue();
            System.out.println(pelicula.getId()+", "+pelicula.getOriginal_title()+", "+pelicula.getCantidadCalificaciones()+", "+pelicula.getOriginal_language());

        }
        System.out.println("por");
        for (int i = 0; i < 5; i++) {
            Pelicula pelicula = peliculasConsultpor.dequeue();
            System.out.println(pelicula.getId()+", "+pelicula.getOriginal_title()+", "+pelicula.getCantidadCalificaciones()+", "+pelicula.getOriginal_language());

        }




    }

    @Override
    public void Top10PeliculasConMejorCalificacionMedia() {

    }

    @Override
    public void Top5ColeccionesConMasIngresos() {

    }

    @Override
    public void Top10DirectoresMejorCalificados() {

    }

    @Override
    public void ActorMasCalificadoPorMes() {

    }

    @Override
    public void UsuariosConMasCalificacionesTop10Generos() {

    }
}

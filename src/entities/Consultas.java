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


        PriorityQueue<Pelicula> peliculasConsultesp = new PriorityQueue<>();
        PriorityQueue<Pelicula> peliculasConsulting = new PriorityQueue<>();
        PriorityQueue<Pelicula> peliculasConsultfra = new PriorityQueue<>();
        PriorityQueue<Pelicula> peliculasConsultita = new PriorityQueue<>();
        PriorityQueue<Pelicula> peliculasConsultpor = new PriorityQueue<>();

        for(HashItem<Integer,Pelicula> item: peliculas.getHashmap()){
            if(item == null){continue;}
            Pelicula pelicula = item.getValue();
            String idioma= pelicula.getOriginal_language();
            switch(idioma) {
                case "en":
                    if (peliculasConsulting.isEmpty()) {
                        peliculasConsulting.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                        continue;
                    }
                    if (peliculasConsulting.size() < 5) {
                        peliculasConsulting.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                        continue;

                    }
                    if (peliculasConsulting.getLast().getCantidadCalificaciones() < pelicula.getCantidadCalificaciones()) {
                        peliculasConsulting.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                        peliculasConsulting.removeLast();
                        continue;
                    }
                    break;

                case "es":
                    if (peliculasConsultesp.isEmpty()) {
                        peliculasConsultesp.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                        continue;
                    }
                    if (peliculasConsultesp.size() < 5) {
                        peliculasConsultesp.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                        continue;

                    }
                    if (peliculasConsultesp.getLast().getCantidadCalificaciones() < pelicula.getCantidadCalificaciones()) {
                        peliculasConsultesp.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                        peliculasConsultesp.removeLast();
                        continue;
                    }
                    break;
                case "fr":
                    if (peliculasConsultfra.isEmpty()) {
                        peliculasConsultfra.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                        continue;
                    }
                    if (peliculasConsultfra.size() < 5) {
                        peliculasConsultfra.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                        continue;

                    }
                    if (peliculasConsultfra.getLast().getCantidadCalificaciones() < pelicula.getCantidadCalificaciones()) {
                        peliculasConsultfra.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                        peliculasConsultfra.removeLast();
                        continue;
                    }
                    break;
                case "it":
                    if (peliculasConsultita.isEmpty()) {
                        peliculasConsultita.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                        continue;
                    }
                    if (peliculasConsultita.size() < 5) {
                        peliculasConsultita.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                        continue;

                    }
                    if (peliculasConsultita.getLast().getCantidadCalificaciones() < pelicula.getCantidadCalificaciones()) {
                        peliculasConsultita.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                        peliculasConsultita.removeLast();
                        continue;
                    }
                    break;
                case "pt":
                    if (peliculasConsultpor.isEmpty()) {
                        peliculasConsultpor.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                        continue;
                    }
                    if (peliculasConsultpor.size() < 5) {
                        peliculasConsultpor.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                        continue;

                    }
                    if (peliculasConsultpor.getLast().getCantidadCalificaciones() < pelicula.getCantidadCalificaciones()) {
                        peliculasConsultpor.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                        peliculasConsultpor.removeLast();
                        continue;
                    }
                    break;

            }
        }
        //Print Ingles
        System.out.println("Ingles");
        for (int i = 0; i < 5; i++) {
            Pelicula pelicula = peliculasConsulting.dequeue();
            System.out.println(pelicula.getId() + ", " + pelicula.getOriginal_title() + ", " + pelicula.getCantidadCalificaciones() + ", " + pelicula.getOriginal_language());
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
        PriorityQueue<Pelicula> peliculasConsult= new PriorityQueue<>();

        for(HashItem<Integer,Pelicula> item: peliculas.getHashmap()) {
            if (item == null) {
                continue;
            }
            Pelicula pelicula = item.getValue();
            if (pelicula.getCantidadCalificaciones() < 100) {
                continue;
            }
            double calificacion = pelicula.getCalificacion();
            if (peliculasConsult.isEmpty()) {
                peliculasConsult.enqueueWithPriority(pelicula, calificacion);
                continue;
            }
            if (peliculasConsult.size() < 10) {
                peliculasConsult.enqueueWithPriority(pelicula, calificacion);
                continue;

            }
            if (peliculasConsult.getLast().getCalificacion() < calificacion ) {
                peliculasConsult.enqueueWithPriority(pelicula, calificacion);
                peliculasConsult.removeLast();
            }
        }

        for (int i = 0; i < 10; i++) {
            Pelicula pelicula = peliculasConsult.dequeue();
            System.out.println(pelicula.getId()+", "+pelicula.getOriginal_title()+", "+pelicula.getCalificacion()+", "+pelicula.getOriginal_language());

        }



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

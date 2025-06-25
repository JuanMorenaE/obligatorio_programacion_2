package entities;

import TADs.Hash.*;
import TADs.Queue.PriorityQueue;
import interfaces.IConsultas;

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


        PriorityQueue<Pelicula> peliculasConsultesp = new PriorityQueue<>(5);
        PriorityQueue<Pelicula> peliculasConsulting = new PriorityQueue<>(5);
        PriorityQueue<Pelicula> peliculasConsultfra = new PriorityQueue<>(5);
        PriorityQueue<Pelicula> peliculasConsultita = new PriorityQueue<>(5);
        PriorityQueue<Pelicula> peliculasConsultpor = new PriorityQueue<>(5);

        for(Pelicula pelicula: peliculas.getValues()){
            String idioma = pelicula.getOriginalLanguage();

            switch(idioma) {
                case "en":
                    peliculasConsulting.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                    break;

                case "es":
                    peliculasConsultesp.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                    break;

                case "fr":
                    peliculasConsultfra.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                    break;

                case "it":
                    peliculasConsultita.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                    break;

                case "pt":
                    peliculasConsultpor.enqueueWithPriority(pelicula, pelicula.getCantidadCalificaciones());
                    break;

            }
        }
        //Print Ingles
        System.out.println("\nIngles");
        for (int i = 0; i < 5; i++) {
            Pelicula pelicula = peliculasConsulting.dequeue();
            System.out.println(pelicula.getId() + ", " + pelicula.getOriginalTitle() + ", " + pelicula.getCantidadCalificaciones() + ", " + pelicula.getOriginalLanguage());
        }
        System.out.println("\nEspañol");
        for (int i = 0; i < 5; i++) {
            Pelicula pelicula = peliculasConsultesp.dequeue();
            System.out.println(pelicula.getId()+", "+pelicula.getOriginalTitle()+", "+pelicula.getCantidadCalificaciones()+", "+pelicula.getOriginalLanguage());

        }
        System.out.println("\nFrances");
        for (int i = 0; i < 5; i++) {
            Pelicula pelicula = peliculasConsultfra.dequeue();
            System.out.println(pelicula.getId()+", "+pelicula.getOriginalTitle()+", "+pelicula.getCantidadCalificaciones()+", "+pelicula.getOriginalLanguage());

        }
        System.out.println("\nItaliano");
        for (int i = 0; i < 5; i++) {
            Pelicula pelicula = peliculasConsultita.dequeue();
            System.out.println(pelicula.getId()+", "+pelicula.getOriginalTitle()+", "+pelicula.getCantidadCalificaciones()+", "+pelicula.getOriginalLanguage());

        }
        System.out.println("\nPortugues");
        for (int i = 0; i < 5; i++) {
            Pelicula pelicula = peliculasConsultpor.dequeue();
            System.out.println(pelicula.getId()+", "+pelicula.getOriginalTitle()+", "+pelicula.getCantidadCalificaciones()+", "+pelicula.getOriginalLanguage());

        }




    }

    @Override
    public void Top10PeliculasConMejorCalificacionMedia() {
        PriorityQueue<Pelicula> peliculasConsult = new PriorityQueue<>();

        for(Pelicula pelicula: peliculas.getValues()) {
            if (pelicula.getCantidadCalificaciones() < 100)
                continue;

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
            System.out.println(pelicula.getId()+", "+pelicula.getOriginalTitle()+", "+pelicula.getCalificacion()+", "+pelicula.getOriginalLanguage());

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

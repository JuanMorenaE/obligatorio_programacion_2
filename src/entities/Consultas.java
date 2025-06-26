package entities;

import TADs.Hash.*;
import TADs.Queue.PriorityQueue;
import interfaces.IConsultas;
import java.text.DateFormatSymbols;
import java.util.ArrayList;

import static entities.UMovie.*;

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
        PriorityQueue<Pelicula> peliculasConsult = new PriorityQueue<>(10);

        for(Pelicula pelicula: peliculas.getValues()) {
            if (pelicula.getCantidadCalificaciones() < 100)
                continue;

            double calificacion = pelicula.getCalificacion();

            peliculasConsult.enqueueWithPriority(pelicula, calificacion);

        }

        System.out.println();
        for (int i = 0; i < 10; i++) {
            Pelicula pelicula = peliculasConsult.dequeue();
            System.out.println(pelicula.getId()+", "+pelicula.getOriginalTitle()+", "+pelicula.getCalificacion()+", "+pelicula.getOriginalLanguage());

        }
    }

    @Override
    public void Top5ColeccionesConMasIngresos() {
        PriorityQueue<Coleccion> coleccionesConsult = new PriorityQueue<>(5);
        for(Coleccion coleccion: colecciones.getValues()){
            long ingresos = coleccion.getIngresos();
            coleccionesConsult.enqueueWithPriority(coleccion, ingresos);
        }

        System.out.println();
        for (int i = 0; i < 5; i++) {
            Coleccion coleccion = coleccionesConsult.dequeue();
            System.out.println(coleccion.getId() + ", " + coleccion.getNombre() + ", " + coleccion.getCantidadPeliculas() + ", " + coleccion + ", " + coleccion.getIngresos());
        }
    }

    @Override
    public void Top10DirectoresMejorCalificados() {
        PriorityQueue<Director> directoresConsult = new PriorityQueue<>(10);
        for(Director director: directores.getValues()){
            if(director.getCantidadPeliculas()<=1 || director.getCantidadCalificaciones()<=100 ){
                double calificacion= director.getCalificaciones();
                directoresConsult.enqueueWithPriority(director, calificacion);
            }
        }

        System.out.println();
        for (int i = 0; i < 10; i++) {
            Director director= directoresConsult.dequeue();
            System.out.println(director.getId() + ", " + director.getCantidadPeliculas() + ", " + director.getCalificaciones());
        }
    }

    @Override
    public void ActorMasCalificadoPorMes() {
        Actor[] actoresConsult = new Actor[12];
        for (Actor actor: actores.getValues()){
            for (int i = 0; i < 12; i++) {
                if(actoresConsult[i]==null||actor.getCalificacionesMes()[i]>actoresConsult[i].getCalificacionesMes()[i]){
                    actoresConsult[i] = actor;
                }
            }
        }

        System.out.println();
        for (int i = 0; i < 12; i++) {
            Actor actor = actoresConsult[1];
            String mes = new DateFormatSymbols().getMonths()[i];
            System.out.println(mes + ", " + actor.getNombre() + ", " + actor.getPeliculasMes()[i] + ", " + actor.getCalificacionesMes()[i]);
        }
    }

    @Override
    public void UsuariosConMasCalificacionesTop10Generos() {
        PriorityQueue<Genero> topGeneros = Top10Generos();
        HashLinear<Integer, PriorityQueue<Usuario>> usuariosPorGenero = new HashLinear<>(topGeneros.size());

        while(!topGeneros.isEmpty()){
            Genero genero = topGeneros.dequeue();
            usuariosPorGenero.add(genero.getId(), new PriorityQueue<>(1));
        }

        for (Usuario usuario: usuarios.getValues()){
            for (HashItem<Integer, Integer> item : usuario.getGenerosCalificados().getValueKeys()){
                PriorityQueue<Usuario> queue = usuariosPorGenero.get(item.getKey());

                if(queue != null)
                    queue.enqueueWithPriority(usuario, item.getValue());
            }
        }

        System.out.println();
        for (HashItem<Integer, PriorityQueue<Usuario>> item : usuariosPorGenero.getValueKeys()){
            if(item != null){
                Usuario usuario = item.getValue().dequeue();
                Genero genero = generos.get(item.getKey());
                System.out.println(usuario.getId() + ", " + genero.getNombre() + ", " + usuario.getGenerosCalificados().get(genero.getId()));
            }
        }
    }

    public PriorityQueue<Genero> Top10Generos() {
        PriorityQueue<Genero> generosConsult = new PriorityQueue<>(10);
        for(Genero genero: generos.getValues()){
            int visita= genero.getVisitas();
            generosConsult.enqueueWithPriority(genero, visita);
        }
        return generosConsult;
    }

}

import entities.UMovie;
import utils.Files;
import entities.Consultas;

import java.util.Scanner;

import static entities.UMovie.peliculas;

public class Main {
    public static void main(String[] args){
        MainMenu();
    }

    public static void MainMenu(){
        boolean exit = false;
        while(!exit){
            System.out.println(
                    """
                        \s
                        \tSeleccione la opción que desee.
                        1.\tCarga de datos.
                        2.\tEjecutar consultas.
                        3.\tSalir.
                   """
            );
            System.out.print("> ");
            Scanner sc = new Scanner(System.in);
            try{
                int option = sc.nextInt();
                switch(option){
                    case 1:
                        long startTime = System.nanoTime();

                        Files.LoadMoviesFromCSV(false);
                        Files.LoadRatingsFromCSV(false);
                        Files.LoadCreditsFromCSV(false);

                        double estimatedTime = (double) (System.nanoTime() - startTime) / 1_000_000_000;

                        System.out.println("\n\tCarga de datos exitosa, tiempo de ejecución de la carga: " + String.format("%.2f", estimatedTime) + " seconds.");
                        break;

                    case 2:
                        ConsultasMenu();
                        break;

                    case 3:
                        exit = true;
                        break;

                    default:
                        System.out.println("\n\tOpción no valida.");
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
    }

    public static void ConsultasMenu(){
        boolean exit = false;
        while(!exit){
            System.out.println(
                    """
                        \s
                        1.\tTop 5 de las películas que más calificaciones por idioma.
                        2.\tTop 10 de las películas que mejor calificación media tienen por parte de los usuarios.
                        3.\tTop 5 de las colecciones que más ingresos generaron.
                        4.\tTop 10 de los directores que mejor calificación tienen.
                        5.\tActor con más calificaciones recibidas en cada mes del año.
                        6.\tUsuarios con más calificaciones por género.
                        7.\tSalir.
                    """
            );
            System.out.print("> ");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            switch(option){
                case 1:
                    long startTime = System.nanoTime();
                    Consultas consultas = new Consultas();
                    consultas.Top5PeliculasPorIdiomaMasCalificadas();
                    double estimatedTime = (double) (System.nanoTime() - startTime) / 1_000_000_000;

                    System.out.println("\n\tTiempo de ejecución de la consulta: " + String.format("%.2f", estimatedTime) + " seconds.");
                    break;

                case 2:
                    long startTime2 = System.nanoTime();
                    Consultas consultas2 = new Consultas();
                    consultas2.Top10PeliculasConMejorCalificacionMedia();
                    double estimatedTime2 = (double) (System.nanoTime() - startTime2) / 1_000_000_000;

                    System.out.println("\n\tTiempo de ejecución de la consulta: " + String.format("%.2f", estimatedTime2) + " seconds.");
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;

                case 6:
                    break;

                case 7:
                    exit = true;
                    break;

                default:
                    System.out.println("\n\tOpción no valida.");
            }
        }
    }
}

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

                        int estimatedTime = (int)(System.nanoTime() - startTime) / 1_000_000;

                        System.out.println("\n\tCarga de datos exitosa, tiempo de ejecución de la carga: " + estimatedTime + " ms.");
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
        Consultas consultas = new Consultas();
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
                    consultas.Top5PeliculasPorIdiomaMasCalificadas();
                    int estimatedTime = (int) (System.nanoTime() - startTime) / 1_000_000;

                    System.out.println("\n\tTiempo de ejecución de la consulta: " + estimatedTime + " ms.");
                    break;

                case 2:
                    long startTime2 = System.nanoTime();
                    consultas.Top10PeliculasConMejorCalificacionMedia();
                    int estimatedTime2 = (int) (System.nanoTime() - startTime2) / 1_000_000;

                    System.out.println("\n\tTiempo de ejecución de la consulta: " + estimatedTime2 + " ms.");
                    break;

                case 3:
                    long startTime3 = System.nanoTime();
                    consultas.Top5ColeccionesConMasIngresos();
                    int estimatedTime3 = (int) (System.nanoTime() - startTime3) / 1_000_000;

                    System.out.println("\n\tTiempo de ejecución de la consulta: " + estimatedTime3 + " ms.");
                    break;

                case 4:
                    long startTime4 = System.nanoTime();
                    consultas.Top10DirectoresMejorCalificados();
                    int estimatedTime4 = (int) (System.nanoTime() - startTime4) / 1_000_000;

                    System.out.println("\n\tTiempo de ejecución de la consulta: " + estimatedTime4 + " ms.");
                    break;

                case 5:
                    long startTime5 = System.nanoTime();
                    consultas.ActorMasCalificadoPorMes();
                    int estimatedTime5 = (int) (System.nanoTime() - startTime5) / 1_000_000;

                    System.out.println("\n\tTiempo de ejecución de la consulta: " + estimatedTime5 + " ms.");
                    break;

                case 6:
                    long startTime6 = System.nanoTime();
                    consultas.UsuariosConMasCalificacionesTop10Generos();
                    int estimatedTime6 = (int) (System.nanoTime() - startTime6) / 1_000_000;

                    System.out.println("\n\tTiempo de ejecución de la consulta: " + estimatedTime6 + " ms.");
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

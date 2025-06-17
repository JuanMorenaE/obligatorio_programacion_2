import entities.UMovie;
import utils.Files;

public class Main {
    public static void main(String[] args){
        Files.LoadMoviesFromCSV();
        Files.LoadCreditsFromCSV();
        Files.LoadRatingsFromCSV();
    }
}

package utils;

import java.io.BufferedReader;
import java.io.FileReader;

public class DataLoading {
    public static void LoadMovies(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("src/datasets/movies_metadata.csv"));
            int lines = 0;
            while(br.ready()){
                br.readLine();
                // Load movies logic goes here.
                lines++;
            }
            System.out.println(lines);
        }
        catch (Exception ex){
            System.out.println("Error ocurred in LoadMovies() : " + ex.getMessage());
        }
    }

    public static void LoadCredits(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("src/datasets/credits.csv"));
            int lines = 0;
            while(br.ready()){
                br.readLine();
                // Load credits logic goes here.
                lines++;
            }
            System.out.println(lines);
        }
        catch (Exception ex){
            System.out.println("Error ocurred in LoadCredits() : " + ex.getMessage());
        }
    }

    public static void LoadRatings(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("src/datasets/ratings_1mm.csv"));
            int lines = 0;
            while(br.ready()){
                br.readLine();
                // Load ratings logic goes here.
                lines++;
            }
            System.out.println(lines);
        }
        catch (Exception ex){
            System.out.println("Error ocurred in LoadRatings() : " + ex.getMessage());
        }
    }
}

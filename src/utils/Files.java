package utils;

import com.opencsv.CSVReader;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class Files {
    public static void LoadMoviesFromCSV(){
        try(CSVReader csv = new CSVReader(new FileReader("src/datasets/movies_metadata.csv"))){
            int lines = 0;

            String[] line;
            csv.readNext(); // We skip .csv headers line.

            while((line = csv.readNext()) != null){
                int id = -1;
                try{
                    id = Integer.parseInt(line[5]);
                }catch(Exception ex){

                }


                int collectionId = -1;
                String collectionName = "";

//                if (line[1].trim() != "") {
//                    JSONObject collection = new JSONObject(line[1]);
//                    collectionId = (int) collection.get("id");
//                    collectionName = (String) collection.get("name");
//                }

//                JSONArray genres = new JSONArray(line[3]);


                long budget = -1;
                try{
                    budget = Long.parseLong(line[2]);
                }catch(Exception ex){

                }


                String language = line[7];
                String title = line[8];
                LocalDate releaseDate = null;
                try{
                    releaseDate = LocalDate.parse(line[12]);
                }catch(Exception ex){

                }

                long revenue = -1;
                try{
                    revenue = Long.parseLong(line[13]);
                }catch(Exception ex){

                }


                DataBuilder.AddMovie(id, collectionId, collectionName, budget, language, title, releaseDate, revenue);
                lines++;
            }

            System.out.println(lines);
        }
        catch (Exception ex){
            System.out.println("Error ocurred in LoadMovies() : " + ex);
        }
    }

    public static void LoadCreditsFromCSV(){
        try(CSVReader csv = new CSVReader(new FileReader("src/datasets/credits.csv"))){
            int lines = 0;

            String[] line;
            csv.readNext(); // We skip .csv headers line.

            while((line = csv.readNext()) != null){

                /* Load credits logic here. */

                lines++;
            }

            System.out.println(lines);
        }
        catch (Exception ex){
            System.out.println("Error ocurred in LoadCredits() : " + ex.getMessage());
        }
    }

    public static void LoadRatingsFromCSV(){
        try(CSVReader csv = new CSVReader(new FileReader("src/datasets/ratings_1mm.csv"))){
            int lines = 0;

            String[] line;
            csv.readNext(); // We skip .csv headers line.

            while((line = csv.readNext()) != null){
                int userId = Integer.parseInt(line[0]);
                int movieId = Integer.parseInt(line[1]);
                int rating = Integer.parseInt(line[2]);

                long timestamp = Long.parseLong(line[3]);
                LocalDate date = Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDate();

                DataBuilder.AddRating(userId, movieId, rating, date);
                lines++;
            }

            System.out.println(lines);
        }
        catch (Exception ex){
            System.out.println("Error ocurred in LoadRatings() : " + ex.getMessage());
        }
    }
}

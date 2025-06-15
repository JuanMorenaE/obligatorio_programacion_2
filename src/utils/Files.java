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
        int lines = 1;
        int strange = 0;
        try(CSVReader csv = new CSVReader(new FileReader("src/datasets/movies_metadata.csv"))){

            String[] line;
            csv.readNext(); // We skip .csv headers line.

            while((line = csv.readNext()) != null){
                lines++;
                if(lines == 9867)
                    System.out.println();

                if(line.length == 19){
                    String[] nextLine = csv.peek();
                    if(nextLine != null && !nextLine[0].equals("FALSE")){
                        csv.skip(1);
                        continue;
                    }
                }
                int id = Integer.parseInt(line[5]);


                int collectionId = -1;
                String collectionName = "";

                if(!line[1].isEmpty()){
                    JSONObject collection = new JSONObject(line[1]);
                    collectionId = (int) collection.get("id");
                    collectionName = (String) collection.get("name");
                }

//                JSONArray genres = new JSONArray(line[3]);


                long budget = Long.parseLong(line[2]);


                String language = line[7];
                String title = line[8];
                LocalDate releaseDate = null;
                if(!line[12].isEmpty())
                    releaseDate = LocalDate.parse(line[12]);

                long revenue = 0;
                if(!line[13].isEmpty())
                    revenue = Long.parseLong(line[13]);


                DataBuilder.AddMovie(id, collectionId, collectionName, budget, language, title, releaseDate, revenue);
            }

            System.out.println(lines);
        }
        catch (Exception ex){
            System.out.println("Error ocurred in LoadMovies() : " + ex + " at line " + lines);
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

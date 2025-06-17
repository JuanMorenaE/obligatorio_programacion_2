package utils;

import com.opencsv.CSVReader;
import entities.UMovie;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

public class Files {
    public static void LoadMoviesFromCSV(){
        int currentLine = 1;
        int movies = 0;
        try(CSVReader csv = new CSVReader(new FileReader("src/datasets/movies_metadata.csv"))){

            String[] line;
            csv.readNext(); // Skipeamos el header del dataset.

            long startTime = System.nanoTime();
            System.out.println("\n[ 🕑 ] Starting LoadMoviesFromCSV() process.");

            while((line = csv.readNext()) != null){
                currentLine++;

                // Nos salteamos aquellas lineas "rotas" del dataset.
                if(line.length == 19){
                    String[] nextLine = csv.peek();
                    if(nextLine != null && !nextLine[0].equals("FALSE")){
                        csv.skip(1);
                        continue;
                    }
                }

                int id = Integer.parseInt(line[5]);

                // Coleccion
                int collectionId = -1;
                String collectionName = "";
                if(!line[1].isEmpty()){
                    JSONObject collectionJSON = new JSONObject(line[1]);
                    collectionId = (int) collectionJSON.get("id");
                    collectionName = (String) collectionJSON.get("name");
                }

                // Generos
                JSONArray genresJSON = new JSONArray(line[3]);
                ArrayList<Integer> genres = new ArrayList<>();
                for (int i = 0; i < genresJSON.length(); i++) {
                    String genreName = genresJSON.getJSONObject(i).getString("name");
                    int genreId = genresJSON.getJSONObject(i).getInt("id");
                    genres.add(genreId);
                    DataBuilder.AddGenre(genreId, genreName);
                }

                long budget = Long.parseLong(line[2]);
                String language = line[7];
                String title = line[8];

                LocalDate releaseDate = null;
                if(!line[12].isEmpty())
                    releaseDate = LocalDate.parse(line[12]);

                long revenue = 0;
                if(!line[13].isEmpty())
                    revenue = Long.parseLong(line[13]);

                DataBuilder.AddMovie(id, collectionId, collectionName, budget, language, title, releaseDate, revenue, genres);
                movies++;
            }

            // Dejamos un log del tiempo que se tomo en cargar las peliculas.
            double estimatedTime = (double) (System.nanoTime() - startTime) / 1_000_000_000;
            System.out.println("[ ✅ ] Finish LoadMoviesFromCSV() process in: " + String.format("%.2f", estimatedTime) + " seconds. \n[ -> ] Total movies: " + movies);
        }
        catch (Exception ex){
            System.out.println("[ ❌ ] Error occurred in LoadMoviesFromCSV() : " + ex + " at line " + currentLine);
        }
    }

    public static void LoadCreditsFromCSV(){
        int currentLine = 1;
        try(CSVReader csv = new CSVReader(new FileReader("src/datasets/credits.csv"))){

            String[] line;
            csv.readNext(); // We skip .csv headers line.

            long startTime = System.nanoTime();
            System.out.println("\n[ 🕑 ] Starting LoadCreditsFromCSV() process...");

            while((line = csv.readNext()) != null){

                int movieId = Integer.parseInt(line[2]);

                try{
                    JSONArray castJSON = new JSONArray(line[0]);
                    for (int i = 0; i < castJSON.length(); i++) {
                        int actorId = castJSON.getJSONObject(i).getInt("id");
                        String actorName = castJSON.getJSONObject(i).getString("name");

//                        DataBuilder.AddActor(movieId, actorId, actorName);
                    }
                }catch(Exception _){

                }

                try{
                    JSONArray crewJSON = new JSONArray(line[1]);
                    for (int i = 0; i < crewJSON.length(); i++) {
                        String department = crewJSON.getJSONObject(i).getString("department");
                        if(!department.equals("Directing"))
                            continue;

                        String job = crewJSON.getJSONObject(i).getString("job");
                        if(!job.equals("Director"))
                            continue;

                        int directorId = crewJSON.getJSONObject(i).getInt("id");
                        String directorName = crewJSON.getJSONObject(i).getString("name");

//                        DataBuilder.AddDirector(movieId, directorId, directorName);

                        break;
                    }
                }catch(Exception _){

                }

                currentLine++;
            }

            // Dejamos un log del tiempo que se tomo en cargar los creditos.
            double estimatedTime = (double) (System.nanoTime() - startTime) / 1_000_000_000;
            System.out.println("[ ✅ ] Finish LoadCreditsFromCSV() process in " + String.format("%.2f", estimatedTime) + " seconds. \n[ -> ] Total credits: " + currentLine);
        }
        catch (Exception ex){
            System.out.println("[ ❌ ] Error occurred in LoadCreditsFromCSV() : " + ex + " at line " + currentLine);
        }
    }

    public static void LoadRatingsFromCSV(){
        int currentLine = 1;
        int ratings = 0;
        try(CSVReader csv = new CSVReader(new FileReader("src/datasets/ratings_1mm.csv"))){

            String[] line;
            csv.readNext(); // We skip .csv headers line.

            long startTime = System.nanoTime();
            System.out.println("\n[ 🕑 ] Starting LoadRatingsFromCSV() process...");

            while((line = csv.readNext()) != null){
                currentLine++;

                int userId = Integer.parseInt(line[0]);
                int movieId = Integer.parseInt(line[1]);
                float rating = Float.parseFloat(line[2]);

                long timestamp = Long.parseLong(line[3]);
                LocalDate date = Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDate();

                DataBuilder.AddRating(userId, movieId, rating, date);
                ratings++;
            }

            // Dejamos un log del tiempo que se tomo en cargar las calificaciones.
            double estimatedTime = (double) (System.nanoTime() - startTime) / 1_000_000_000;
            System.out.println("[ ✅ ] Finish LoadRatingsFromCSV() process in " + String.format("%.2f", estimatedTime) + " seconds. \n[ -> ] Total ratings: " + ratings);
        }
        catch (Exception ex){
            System.out.println("[ ❌ ] Error occurred in LoadRatingsFromCSV() : " + ex + " at line " + currentLine);
        }
    }
}

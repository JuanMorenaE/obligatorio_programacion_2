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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Files {
    private static final Pattern DIRECTOR_PATTERN = Pattern.compile(
            "'department':\\s*'Directing'[^}]*?'id':\\s*(\\d+)[^}]*?'job':\\s*'Director'[^}]*?'name':\\s*'([^']+)'"
    );

    private static final Pattern ACTOR_PATTERN = Pattern.compile(
            "\\{[^}]*'id'\\s*:\\s*(\\d+)[^}]*'name'\\s*:\\s*'([^']+)'[^}]*\\}"
    );

    public static void LoadMoviesFromCSV(boolean debugLogs){
        int currentLine = 1;
        int movies = 0;
        try(CSVReader csv = new CSVReader(new FileReader("src/datasets/movies_metadata.csv"))){

            String[] line;
            csv.readNext(); // Skipeamos el header del dataset.

            long startTime = 0;
            if(debugLogs){
                startTime = System.nanoTime();
                System.out.println("\n[ 🕑 ] Empezando proceso LoadMoviesFromCSV()...");
            }

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

            if(debugLogs){
                double estimatedTime = (double) (System.nanoTime() - startTime) / 1_000_000_000;
                System.out.println("[ ✅ ] Finalizado el proceso LoadMoviesFromCSV() en: " + String.format("%.2f", estimatedTime) + " segundos. \n[ -> ] Total peliculas: " + movies);
            }
        }
        catch (Exception ex){
            System.out.println("[ ❌ ] Error ocurrido en LoadMoviesFromCSV() : " + ex + " en la linea " + currentLine);
        }
    }

    public static void LoadCreditsFromCSV(boolean debugLogs){
        int currentLine = 1;
        try(CSVReader csv = new CSVReader(new FileReader("src/datasets/credits.csv"))){

            String[] line;
            csv.readNext(); // We skip .csv headers line.

            long startTime = 0;
            if(debugLogs){
                startTime = System.nanoTime();
                System.out.println("\n[ 🕑 ] Empezando proceso LoadCreditsFromCSV()...");
            }

            while((line = csv.readNext()) != null){

                int movieId = Integer.parseInt(line[2]);

                if(!line[0].isEmpty()){
                    Matcher actorMatcher = ACTOR_PATTERN.matcher(line[0]);
                    while(actorMatcher.find()) {
                        int actorId = Integer.parseInt(actorMatcher.group(1));
                        String actorName = actorMatcher.group(2);

                         DataBuilder.AddActor(movieId, actorId, actorName);
                    }
                }

                if(!line[1].isEmpty()){
                    Matcher directorMatcher = DIRECTOR_PATTERN.matcher(line[1]);
                    if(directorMatcher.find()) {
                        int directorId = Integer.parseInt(directorMatcher.group(1));
                        String directorName = directorMatcher.group(2);

                         DataBuilder.AddDirector(movieId, directorId, directorName);
                    }
                }

                currentLine++;
            }

            if(debugLogs){
                double estimatedTime = (double) (System.nanoTime() - startTime) / 1_000_000_000;
                System.out.println("[ ✅ ] Finalizado el proceso LoadCreditsFromCSV() en: " + String.format("%.2f", estimatedTime) + " segundos. \n[ -> ] Total calificaciones: " + currentLine);
            }
        }
        catch (Exception ex){
            System.out.println("[ ❌ ] Error ocurrido en LoadCreditsFromCSV() : " + ex + " en la linea " + currentLine);
        }
    }

    public static void LoadRatingsFromCSV(boolean debugLogs){
        int currentLine = 1;
        int ratings = 0;
        try(CSVReader csv = new CSVReader(new FileReader("src/datasets/ratings_1mm.csv"))){

            String[] line;
            csv.readNext(); // We skip .csv headers line.

            long startTime = 0;
            if(debugLogs){
                startTime = System.nanoTime();
                System.out.println("\n[ 🕑 ] Empezando proceso LoadRatingsFromCSV()...");
            }

            while((line = csv.readNext()) != null){
                currentLine++;

                int userId = Integer.parseInt(line[0]);
                int movieId = Integer.parseInt(line[1]);
                float rating = Float.parseFloat(line[2]);

                long timestamp = Long.parseLong(line[3]);
                LocalDate date = Instant.ofEpochSecond(timestamp).atZone(ZoneId.systemDefault()).toLocalDate();

                DataBuilder.AddRating(userId, movieId, rating, date);
                ratings++;
            }

            if(debugLogs){
                double estimatedTime = (double) (System.nanoTime() - startTime) / 1_000_000_000;
                System.out.println("[ ✅ ] Finalizado el proceso LoadRatingsFromCSV() en: " + String.format("%.2f", estimatedTime) + " segundos. \n[ -> ] Total ratings: " + ratings);
            }
        }
        catch (Exception ex){
            System.out.println("[ ❌ ] Error ocurrido en LoadRatingsFromCSV() : " + ex + " en la linea " + currentLine);
        }
    }
}

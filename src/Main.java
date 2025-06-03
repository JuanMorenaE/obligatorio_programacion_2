import netscape.javascript.JSObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        try (Scanner scanner = new Scanner(new File("src/movies_metadata.csv"))) {
            int lines = 0;

            // Leer cada línea del archivo
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine(); // Avanza una línea
                lines++;            // Cuenta la línea
            }

            System.out.println("¡Finalizado! Total de líneas: " + lines);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileSaving {



    public static void save(String fileName, String value, String value2) {
        try{
            List<String> lines = Arrays.asList("Bonjour petit lutin ! \n\nVotre mission cette année est de trouver un cadeau pour "+value+" que vous lui offrirez le "+value2+".\n\n\t\tATTENTION !\nN'oubliez pas de rester discret car les autres peuvent tenter de trouver le nom de l'heureux élu.\nVous pouvez d'ailleurs à votre tour tenter de deviner le leur.\n\n\n\t\tBonne chance pour votre mission et Joyeux Noël !");
            Path file = Paths.get(fileName);
            Files.write(file, lines, StandardCharsets.UTF_8);
        }
        catch (
                IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

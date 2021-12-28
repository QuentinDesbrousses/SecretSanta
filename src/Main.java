import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //Participants
        Participant cindy = new Participant("Cindy","cindy.dsbrsss@gmail.com","1");
        Participant anneso = new Participant("Anne-So","annesophie.desbrousses@gmail.com","2");
        Participant steven = new Participant("Steven","chavesfc2306@gmail.com","3");
        Participant djamel = new Participant("Djamel","djamelhamidi2008@gmail.com","4");
        Participant manon = new Participant("Manon","mandesbrousses@gmail.com","A");
        Participant quentin = new Participant("Quentin","q.desbrousses@gmail.com","B");
        Participant melany = new Participant("Mélany","chartiersandra54@gmail.com","C");
        Participant sandra = new Participant("Sandra","memaquesan@gmail.com","D");
        Participant noham = new Participant("Noham","noham.oulma@gmail.com","E");

        //Groupe 1
        ArrayList<Participant> groupe1 = new ArrayList<>();
        groupe1.add(cindy);
        groupe1.add(anneso);
        groupe1.add(steven);
        groupe1.add(djamel);

        //Groupe 2
        ArrayList<Participant> groupe2 = new ArrayList<>();
        groupe2.add(manon);
        groupe2.add(quentin);
        groupe2.add(melany);
        groupe2.add(sandra);
        groupe2.add(noham);

        //Date
        String date = "25 Décembre 2021";

        //Jeu
        SecretSanta s = new SecretSanta(groupe1,groupe2,date);
        HashMap<String,String> Resultat = s.lancement();

        //Ecriture dans fichier
        Iterator it = Resultat.entrySet().iterator();
        for (Map.Entry<String, String> entry : Resultat.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            //System.out.println("Envoyeur : "+key+" / Receveur : "+value);
            String fileName ="Enveloppes/"+key+".txt";
            FileSaving.save(fileName,value,date);
        }
    }
}

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SecretSanta {
    private static int id = 0;
    private ArrayList<Participant> groupe1;
    private ArrayList<Participant> groupe2;
    private String date;

    public SecretSanta(ArrayList groupe1, ArrayList groupe2, String date) {
        this.groupe1 = groupe1;
        this.groupe2 = groupe2;
        this.date = date;
        this.id+=1;
    }

    public static int getId() {
        return id;
    }

    public ArrayList getGroupe1() {
        return groupe1;
    }

    public void setGroupe1(ArrayList groupe1) {
        this.groupe1 = groupe1;
    }

    public ArrayList getGroupe2() {
        return groupe2;
    }

    public void setGroupe2(ArrayList groupe2) {
        this.groupe2 = groupe2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static String getMailByName(ArrayList<Participant> groupe, String name){
        String mail = "";
        for(Participant p : groupe){
            if(p.getNom()==name){
                mail = p.getMail();
            }
        }
        return mail;
    }

    public HashMap<String,String> lancement(){
        HashMap<String,String> res = new HashMap<>();
        System.out.println("Taille groupe 1 : "+ this.groupe1.size());
        System.out.println("Taille groupe 2 : "+ this.groupe2.size());
        ArrayList<Participant> current1 = new ArrayList<>();
        ArrayList<Participant> current2 = (ArrayList<Participant>) this.groupe2.clone();
        ArrayList<Participant> current3 = (ArrayList<Participant>) this.groupe2.clone();
        System.out.println("Taille current1 : "+ current1.size());
        System.out.println("Taille current2 : "+ current2.size());
        System.out.println("Taille current3 : "+ current3.size());
        System.out.println("groupe 1 choisit");
        // groupe 1 choisit
        // Entrée : current1 vide, current2 = groupe2, current3 = groupe2
        // Sortie : current1 correspond aux participants du groupe 1 n'ayant pas encore été choisi mais ayant choisi un participant
        // current2 correspond aux participants du groupe 2 n'ayant pas été choisit
        // current3 correspond aux participants du groupe 2 n'ayant pas encore choisit = groupe2
        for (Participant p : this.groupe1){
            // s'il reste des participants libres dans le groupe 2
            if(current2.size() != 0){
                int randomNumber = (int) ((Math.random() * (current2.size())));
                p.setNomReceveur(current2.get(randomNumber).getNom());
                current2.remove(randomNumber);
                current1.add(p);
            }
            // s'il n'y a plus de participant libre dans le groupe 2
            //le participant choisit dans son propre groupe parmis ceux qui ont déja choisi un participant
            else {
                int randomNumber = (int) ((Math.random() * (current1.size())));
                p.setNomReceveur(current1.get(randomNumber).getNom());
                current1.remove(randomNumber);
                current1.add(p);
            }
        }
        System.out.println("Taille groupe 1 : "+ this.groupe1.size());
        System.out.println("Taille groupe 2 : "+ this.groupe2.size());
        System.out.println("Taille current1 : "+ current1.size());
        System.out.println("Taille current2 : "+ current2.size());
        System.out.println("Taille current3 : "+ current3.size());

        if(current2.size()!=0){
            System.out.println("il reste "+current2.size()+" participant(s) non choisi(s) dans le groupe 2");
            // s'il reste des participants non choisis dans le groupe 2
            // des participants de leur propre groupe doivent les choisir
            // Sortie : current2.size() == 0 donc tous les participants du groupe 2 ont été choisi
            // current3 correspond aux participants du groupe 2 n'ayant pas encore choisi
            // current1 correspond aux participants du groupe 1 n'ayant pas encore été choisi mais ayant choisi un participant
            // on doit avoir current1.size() == current3.size()
            for(Participant p : current2){
                int randomNumber = 0;
                // tant qu'on ne prend pas un participant du groupe 2 différent du participant actuel
                // on cherche
                int i = 0;
                while(this.groupe2.get(randomNumber).getNom()==p.getNom()){
                    randomNumber = (int) ((Math.random() * (this.groupe2.size())));
                }
                this.groupe2.get(randomNumber).setNomReceveur(p.getNom());
                current3.remove(this.groupe2.get(randomNumber));
            }
        }

        System.out.println("groupe 2 choisit");
        // groupe 2 choisit
        System.out.println("Test :"+ (current1.size() == current3.size()));
        for(Participant p : current3){
            int randomNumber = (int) ((Math.random() * (current1.size())));
            p.setNomReceveur(current1.get(randomNumber).getNom());
            current1.remove(randomNumber);
        }
        System.out.println("Affichage du résultat");
        for(Participant p : this.groupe1){
            System.out.println(p.getNom()+" -> "+p.getNomReceveur());
            res.put(p.getNom(),p.getNomReceveur());
        }
        for(Participant p : this.groupe2){
            System.out.println(p.getNom()+" -> "+p.getNomReceveur());
            res.put(p.getNom(),p.getNomReceveur());
        }
        return res;
    }
}

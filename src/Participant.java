public class Participant {
    private String nom;
    private String mail;
    private String nomReceveur;
    private String groupeId;

    public Participant(String nom, String mail, String groupeId) {
        this.nom = nom;
        this.mail = mail;
        this.nomReceveur = "";
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNomReceveur() {
        return nomReceveur;
    }

    public void setNomReceveur(String nomReceveur) {
        this.nomReceveur = nomReceveur;
    }

    public String getGroupeId() {
        return groupeId;
    }
}

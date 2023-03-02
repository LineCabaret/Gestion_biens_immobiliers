package rapport;

public class Creneau {
	
    private String jourSemaine;
    private String groupe;
    private String heureDebut;
    private String heureFin;
    private String typeCours;
    private String materie;

    public Creneau(String jourSemaine, String groupe, String heureDebut, String heureFin, String typeCours, String materie) {
        this.jourSemaine = jourSemaine;
        this.groupe = groupe;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.typeCours = typeCours;
        this.materie = materie;
    }

    public String getJourSemaine() {
        return jourSemaine;
    }

    public String getGroupe() {
        return groupe;
    }

    public String getHeureDebut() {
        return heureDebut;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public String getTypeCours() {
        return typeCours;
    }

    public String getMaterie() {
        return materie;
    }
}

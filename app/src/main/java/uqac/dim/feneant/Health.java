package uqac.dim.feneant;

import java.util.Date;

public class Health {
    private int idHealth;
    private String nameTache;
    private String description;
    private String echeance_jour;
    private String echeance_heure;

    public Health(String nameTache, String description, String echeance_jour,String echeance_heure) {

        this.setNameTache(nameTache);
        this.setDescription(description);
        this.echeance_jour=echeance_jour;
        this.echeance_heure=echeance_heure;
    }

    public String getNameTache() {
        return nameTache;
    }

    public void setNameTache(String nameTache) {
        this.nameTache = nameTache;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEcheance_jour() {
        return echeance_jour;
    }

    public String getEcheance_heure() {
        return echeance_heure;
    }

    public int getIdHealth() {
        return idHealth;
    }

}

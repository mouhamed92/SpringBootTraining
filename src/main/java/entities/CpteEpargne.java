package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("CE")
public class CpteEpargne extends Compte {

    private double taux ;

    public CpteEpargne() {

    }

    public CpteEpargne(String codeCpte, Date dateCreation, double solde, Client client, double taux) {
        super(codeCpte, dateCreation, solde, client);
        this.taux = taux;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}

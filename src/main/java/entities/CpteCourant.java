package entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("CC")
public class CpteCourant extends Compte {

    private double decuverte ;

    public CpteCourant() {

    }

    public CpteCourant(String codeCpte, Date dateCreation, double solde, Client client, double decuverte) {
        super(codeCpte, dateCreation, solde, client);
        this.decuverte = decuverte;
    }

    public double getDecuverte() {
        return decuverte;
    }

    public void setDecuverte(double decuverte) {
        this.decuverte = decuverte;
    }
}

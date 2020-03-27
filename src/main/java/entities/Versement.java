package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("Ver")
public class Versement extends Operation {

    public Versement() {
    }

    public Versement(Date dateOp, double montant, Compte compte) {
        super(dateOp, montant, compte);
    }
}

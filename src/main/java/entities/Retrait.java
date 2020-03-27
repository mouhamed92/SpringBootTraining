package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("Ret")
public class Retrait extends Operation {

    public Retrait() {
    }

    public Retrait(Date dateOp, double montant, Compte compte) {

        super(dateOp, montant, compte);
    }
}

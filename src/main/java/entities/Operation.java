package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy =InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_OP")
public abstract class Operation {

    @Id @GeneratedValue
    private long num;
    private Date dateOp;
    private double montant ;
    @ManyToOne
    @JoinColumn(name = "CODE_COMPTE")
    private Compte compte ;


    public Operation() {
    }

    public Operation(Date dateOp, double montant, Compte compte) {
        this.dateOp = dateOp;
        this.montant = montant;
        this.compte = compte;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public Date getDateOp() {
        return dateOp;
    }

    public void setDateOp(Date dateOp) {
        this.dateOp = dateOp;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}

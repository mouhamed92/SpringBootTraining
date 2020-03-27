package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Inheritance(strategy =InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name ="TYPE_COMPTE")
public abstract class Compte implements Serializable {

    @Id
    private String codeCpte ;
    private Date dateCreation ;
    private double solde ;
    @ManyToOne
    @JoinColumn(name = "Code_ClI")
    private Client client ;
    @OneToMany(mappedBy ="compte")
    private Collection <Operation> operations ;

    public Compte() {
    }

    public Compte(String codeCpte, Date dateCreation, double solde, Client client) {
        this.codeCpte = codeCpte;
        this.dateCreation = dateCreation;
        this.solde = solde;
        this.client = client;
    }

    public String getCodeCpte() {
        return codeCpte;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public double getSolde() {
        return solde;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setOperations(Collection<Operation> operations) {
        this.operations = operations;
    }

    public Client getClient() {
        return client;
    }

    public Collection<Operation> getOperations() {
        return operations;
    }
}

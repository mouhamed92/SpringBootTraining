package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Client implements Serializable {

    @Id @GeneratedValue
    private long code ;
    private String nom ;
    private  String email ;
    @OneToMany(mappedBy ="client",fetch = FetchType.EAGER )
    private Collection<Compte> comptes ;

    public Client() {
    }


    public Client(long code ,String nom, String email) {
        this.code = code ;
        this.nom = nom;
        this.email = email;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Collection<Compte> comptes) {
        this.comptes = comptes;
    }

    @Override
    public String toString() {
        return "Client{" +
                "code=" + code +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", comptes=" + comptes.toString() +
                '}';
    }
}

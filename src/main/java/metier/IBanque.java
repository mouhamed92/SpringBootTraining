package metier;

import entities.Compte;
import org.springframework.stereotype.Component;


public interface IBanque {

    public Compte consulterCompte(String id);
    public void retrait(double montant , String c);
    public void verser(double montant , String c);
    public void virement(double montant,String c1,String  c2);
}

package metier;

import dao.CompteRepository;
import dao.OperationRepository;
import entities.Compte;
import entities.CpteCourant;
import entities.Retrait;
import entities.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
@Component(value = "a")
public class IBanqueImpl implements IBanque {

    @Autowired
    CompteRepository compteRepository ;

    @Autowired
    OperationRepository operationRepository ;

    @Override
    public Compte consulterCompte(String id) {

        Compte compte = compteRepository.findOne(id);
        if (compte==null)
            throw new RuntimeException("comtpte introuvable");
               return compte ;
    }

    @Override
    public void retrait(double montant, String c) {

       Compte compte = consulterCompte(c);
       if ( compte instanceof CpteCourant){
           double d = ((CpteCourant) compte).getDecuverte();
               if (montant>d)
                   throw new RuntimeException("solde insuffisant");}
        Retrait retrait = new Retrait(new Date(),montant,compte);
        operationRepository.save(retrait);
        compte.setSolde(compte.getSolde()-montant);
        compteRepository.save(compte);

    }

    @Override
    public void verser(double montant, String c) {

        Compte compte = consulterCompte(c);
        Versement versement = new Versement(new Date(),montant,compte);
        operationRepository.save(versement);
        compte.setSolde(compte.getSolde()+montant);
        compteRepository.save(compte);


    }

    @Override
    public void virement(double montant, String c1, String c2) {

        retrait(montant,c1);
        verser(montant,c2);

    }
}

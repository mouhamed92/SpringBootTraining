package extension;

import dao.CompteRepository;
import dao.OperationRepository;
import entities.Compte;
import entities.Versement;
import metier.IBanque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
@Component(value = "a")
@Transactional
public class IbanqueImpl2 implements IBanque {

    @Autowired
    private CompteRepository compteRepository ;

    @Autowired
    private OperationRepository operationRepository ;

    @Override
    public Compte consulterCompte(String id) {
        Compte compte = compteRepository.findOne(id);
        if (compte==null)
            throw new RuntimeException("comtpte introuvable");
        return compte ;

    }

    @Override
    public void retrait(double montant, String c) {

    }

    @Override
    public void verser(double montant, String c) {

        Compte compte = consulterCompte(c);
        Versement versement = new Versement(new Date(),montant,compte);
        operationRepository.save(versement);
        compte.setSolde(compte.getSolde()+montant+3.5);
        compteRepository.save(compte);
    }

    @Override
    public void virement(double montant, String c1, String c2) {

    }
}

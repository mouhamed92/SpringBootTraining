package tn.isims.gestionbancaire;

import dao.ClientRepository;
import dao.CompteRepository;
import dao.OperationRepository;
import entities.*;
import metier.IBanque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;

@EnableJpaRepositories(basePackages = "dao")
@EntityScan(basePackages ="entities")
@ComponentScan(basePackages = "metier")
@SpringBootApplication
public class GestionbancaireApplication implements CommandLineRunner {

    @Autowired
    private  ClientRepository clientRepository ;

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private OperationRepository operationRepository ;


    @Autowired
    @Qualifier("a")
    private IBanque iBanque ;

    public static void main(String[] args) {
        SpringApplication.run(GestionbancaireApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

      Client c1 =  clientRepository.save(new Client("mohamed","email@gmail.com"));
      Compte cp1 = compteRepository.save(new CpteCourant("cp1",new Date(),9000,c1,600));

        Client c2 =  clientRepository.save(new Client("Ali","email@gmail.com"));
        Compte cp2 = compteRepository.save(new CpteCourant("cp2",new Date(),5000,c1,100));

        iBanque.verser(1000,"cp1");
        iBanque.virement(300,"cp1","cp2");
    }
}

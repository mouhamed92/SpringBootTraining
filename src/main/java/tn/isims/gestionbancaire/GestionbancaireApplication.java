package tn.isims.gestionbancaire;

import dao.ClientRepository;
import dao.CompteRepository;
import dao.OperationRepository;
import entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;

@EnableJpaRepositories(basePackages = "dao")
@EntityScan(basePackages ="entities")
@SpringBootApplication
public class GestionbancaireApplication implements CommandLineRunner {

    @Autowired
    private  ClientRepository clientRepository ;

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private OperationRepository operationRepository ;

    public static void main(String[] args) {
        SpringApplication.run(GestionbancaireApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

      Client c1 =  clientRepository.save(new Client(0 ,"mohamed","mohamed@gmail.com"));
      Client c2 =  clientRepository.save(new Client(0,"Ali","ali@gmail.com"));
      Client c3 =  clientRepository.save(new Client(0,"esmail","esmail@gmail.com"));

      Compte cp1 = compteRepository.save(new CpteCourant("cp1",new Date(),9000,c1,600));
      Compte cp2 = compteRepository.save(new CpteCourant("cp2",new Date(),5000,c2,100));
      Compte cp3 = compteRepository.save(new CpteCourant("cp3",new Date(),5000,c3,200));

        Page<Client> clients = clientRepository.findAll(( PageRequest.of(0,2)));

        clients.getContent().forEach(client -> {
            System.out.println(client.toString());
        });

    }
}

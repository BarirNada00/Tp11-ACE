package ma.rest.tp11;

import ma.rest.tp11.entities.Client;
import ma.rest.tp11.entities.Compte;
import ma.rest.tp11.entities.TypeCompte;
import ma.rest.tp11.repository.ClientRepository;
import ma.rest.tp11.repository.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class Tp11Application {
    public static void main(String[] args) {
        SpringApplication.run(Tp11Application.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository, ClientRepository clientRepository, RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Compte.class, Client.class);

            Client c1 = clientRepository.save(new Client(null, "Amal", "amal@example.com", null));
            Client c2 = clientRepository.save(new Client(null, "Ali", "ali@example.com", null));

            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE, c1));
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.COURANT, c1));
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE, c2));

            System.out.println("Database initialized with 2 clients and 3 accounts");
        };
    }
}
package galerie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import galerie.dao.ExpositionRepository;
import galerie.dao.GalerieRepository;
import galerie.dao.PersonneRepository;
import lombok.extern.log4j.Log4j2;

import galerie.entity.*;
import galerie.dao.*;

@Component
@Log4j2 // Génère le 'logger' pour afficher les messages de trace
public class ConsoleApp implements CommandLineRunner {

    @Autowired
    private ExpositionRepository expositionDAO;
    private GalerieRepository galerieDAO;
    private PersonneRepository personneDAO;

    @Override
    /**
     * Equivalent de la méthode 'main' pour une application Spring Boot
     **/
    public void run(String... args) throws Exception {
        
        tapezEnterPourContinuer();    

        log.info("Démo");
        
    }

    public static void tapezEnterPourContinuer() throws Exception {
        System.out.println("Tapez \"ENTER\" pour continuer...");
        System.in.read();
    }
}

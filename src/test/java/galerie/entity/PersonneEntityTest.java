package galerie.entity;

import galerie.dao.PersonneRepository;
import galerie.entity.Personne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;

@Log4j2 // Génère le 'logger' pour afficher les messages de trace
@DataJpaTest
@Sql("test-data.sql") // On peut charger des donnnées spécifiques pour un test
public class PersonneEntityTest {

    @Autowired
    private PersonneRepository personneDAO;

    @Test
    public void onSaitCompterLesEnregistrements() {
        log.info("On compte les enregistrements de la table 'Personne'");
        int combienDansLeJeuDeTest = 3; 
        long nombre = personneDAO.count();
        assertEquals(combienDansLeJeuDeTest, nombre, "On doit trouver 3 personnes" );
    }
    
    @Test
    public void chiffreAffaireAnnuelEntity() {
        log.info("On calcule le budget pour la personne d'id 3");
        Personne personne = personneDAO.getOne(3);
        float budget = personne.budgetArt(2010);
        assertEquals(150, budget, "On doit trouver un budget de 150");
    }

}

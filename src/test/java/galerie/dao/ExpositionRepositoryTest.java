package galerie.dao;

import galerie.entity.Exposition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;
import galerie.dao.ExpositionRepository;


@Log4j2 // Génère le 'logger' pour afficher les messages de trace
@DataJpaTest
@Sql("test-data.sql")
public class ExpositionRepositoryTest {

    @Autowired
    private ExpositionRepository expositionDAO;

    @Test
    public void onSaitCompterLesEnregistrements() {
        log.info("On compte les enregistrements de la table 'Exposition'");
        int combienDansLeJeuDeTest = 1; 
        long nombre = expositionDAO.count();
        assertEquals(combienDansLeJeuDeTest, nombre, "On doit trouver 1 exposition" );
    }

    @Test
    public void chiffreAffaireRepository() {
        log.info("On calcule le chiffre d'affaire pour l'Exposition d'id 1 via la fonction du Repository");
        float ca = expositionDAO.chiffreAffairePour(1);
        assertEquals(150, ca, "On doit trouver un CA de 150");
    }
    
    @Test
    public void chiffreAffaireEntity() {
        log.info("On calcule le chiffre d'affaire pour l'Exposition d'id 1 via la fonction de l'Entity");
        Exposition exp = expositionDAO.getOne(1);
        float ca = exp.chiffreAffaire();
        assertEquals(150, ca, "On doit trouver un CA de 150");
    }
}

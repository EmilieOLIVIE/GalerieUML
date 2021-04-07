package galerie.dao;

import galerie.entity.Galerie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;
import galerie.dao.GalerieRepository;


@Log4j2 // Génère le 'logger' pour afficher les messages de trace
@DataJpaTest
@Sql("test-data.sql") // On peut charger des donnnées spécifiques pour un test
public class GalerieRepositoryTest {

    @Autowired
    private GalerieRepository galerieDAO;

    @Test
    @Sql("test-data.sql") // On peut charger des donnnées spécifiques pour un test
    public void onSaitCompterLesEnregistrements() {
        log.info("On compte les enregistrements de la table 'Galerie'");
        int combienDansLeJeuDeTest = 1; 
        long nombre = galerieDAO.count();
        assertEquals(combienDansLeJeuDeTest, nombre, "On doit trouver 1 galerie" );
    }
    
    @Test
    public void chiffreAffaireAnnuelEntity() {
        log.info("On calcule le chiffre d'affaire pour la Galerie d'id 1");
        Galerie gal = galerieDAO.getOne(1);
        float ca = gal.CAannuel(LocalDate.now().getYear());
        assertEquals(150, ca, "On doit trouver un CA de 150");
    }

}

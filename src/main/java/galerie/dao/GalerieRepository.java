package galerie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import galerie.entity.Galerie;

// This will be AUTO IMPLEMENTED by Spring 

public interface GalerieRepository extends JpaRepository<Galerie, Integer> {
    /**
     * Calculer le chiffre d'affaires de la galerie pour une année donnée
     * @param l'année pour laquelle on veut calculer le chiffre d'affaires
     * @return le chiffre d'affaires de cette année
     */
    //float CAannuel(Integer annee);
}

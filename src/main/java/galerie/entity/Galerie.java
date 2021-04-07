package galerie.entity;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;
import lombok.*;

// Un exemple d'entité
// On utilise Lombok pour auto-générer getter / setter / toString...
// cf. https://examples.javacodegeeks.com/spring-boot-with-lombok/
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Galerie {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column(unique=true)
    @NonNull
    private String nom;
    
    @Column(unique=true)
    @NonNull
    private String adresse;
    
    @OneToMany(mappedBy = "organisateur")
    private List<Exposition> evenements = new LinkedList<Exposition>();    
    
    /**
     * Calculer le chiffre d'affaires de la galerie pour une année donnée
     * @param l'année pour laquelle on veut calculer le chiffre d'affaires
     * @return le chiffre d'affaires de cette année
     */
    public float CAannuel(Integer annee) {
    	float caAnnuel = 0;
		for (Exposition exposition : evenements) {
			if(exposition.getDebut().getYear() == annee) caAnnuel += exposition.chiffreAffaire();
		}
		return caAnnuel;
    }
}

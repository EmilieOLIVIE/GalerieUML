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
public class Personne {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column(unique=true)
    @NonNull
    private String nom;
    
    @Column(unique=true)
    @NonNull
    private String adresse;
    
    @OneToMany(mappedBy = "client")
    private List<Transaction> achats = new LinkedList<Transaction>();
    
    /**
     * Calculer le budget art pour une personne
     * @param l'année pour laquelle on souhaite calculer le budget
     * @return le budget pour l'année
     */
    public float budgetArt(Integer annee) {
    	float budget = 0;
    	for (Transaction transaction : achats) {
			if(transaction.getVenduLe().getYear() == annee) budget += transaction.getPrixVente();
		}
    	return budget;
    }
}

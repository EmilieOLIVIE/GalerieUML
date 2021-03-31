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
public class Artiste extends Personne {
	@NonNull
    private String biographie;
	
	@OneToMany(mappedBy = "auteur")
	private List<Tableau> oeuvres = new LinkedList();
    
}

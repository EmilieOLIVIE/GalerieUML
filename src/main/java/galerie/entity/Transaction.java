package galerie.entity;
import javax.persistence.*;
import lombok.*;
import java.time.LocalDate;

// Un exemple d'entité
// On utilise Lombok pour auto-générer getter / setter / toString...
// cf. https://examples.javacodegeeks.com/spring-boot-with-lombok/
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Transaction {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column
    @NonNull
    private LocalDate venduLe;
    
    @Column
    private float prixVente;

    @OneToOne
    private Tableau oeuvre;
    
    @ManyToOne
    private Personne client;
    
    @ManyToOne
    private Exposition lieuDeVente;
}

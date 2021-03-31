package galerie.entity;
import java.util.LinkedList;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import lombok.*;

// Un exemple d'entité
// On utilise Lombok pour auto-générer getter / setter / toString...
// cf. https://examples.javacodegeeks.com/spring-boot-with-lombok/
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Exposition {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    @Column
    private LocalDate debut;
    
    @Column
    @NonNull
    private String intitule;
    
    @Column
    private int duree;
    
    /* 
     * Pour la mise en place de relations Many-to-Many (Tableau ⟷ Exposition), 
     * il faut préciser une annotation "mappedBy" d'un côté, comme pour une association One-to-Many. 
     * Une table de jointure sera automatiquement générée.
     */
    /* @ManyToMany
    List<Tableau> oeuvres = new LinkedList<>();
    */
    
    /*
     * On peut également préciser davantage les caractéristiques de la table de jointure si nécessaire par l'annotation @JoinTable.
     */
    @ManyToMany
    @JoinTable(name="expo_tableau",
        joinColumns = 
                @JoinColumn(name = "exposition_id", referencedColumnName="id"),
        inverseJoinColumns = 
                @JoinColumn(name = "tableau_id",  referencedColumnName="id")
    )            
    List<Tableau> oeuvres = new LinkedList<>();
}

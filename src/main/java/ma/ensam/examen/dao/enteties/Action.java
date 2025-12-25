package ma.ensam.examen.dao.enteties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date date_creation;
    private double montant;
    private ActionStatus status;
    @ManyToOne
    private Organisateur organisateur;
    @OneToMany(mappedBy = "action")
    private List<Don> dons;
}
package peoplelocation.peoplelocation.entites;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.web.bind.annotation.CrossOrigin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@CrossOrigin("*")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Candidates implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;
    private String fullname;
    private Date birthDate;
    private String sexe;
    private String civility;
    private String adress;
    private Integer childrenNum;
    private Integer exprience_num;
    private Integer phone;
    @ManyToOne
    private Villes villes;
    @ManyToOne
    private States states;
    @ManyToOne
    private Types types;
    @ManyToOne
    private Speciality speciality;
    @ManyToOne
    private Nationality nationality;
    @ManyToOne
    private Users users;
    @ManyToOne
    private AcademicLevels academicLevels;
    @OneToMany(mappedBy = "candidates")
    Collection<Interviews> interviews;
    @OneToMany(mappedBy = "candidates")
    Collection<CdtPostes> cdtPostes;
    @OneToMany(mappedBy = "candidates")
    Collection<Folders> folders;

}

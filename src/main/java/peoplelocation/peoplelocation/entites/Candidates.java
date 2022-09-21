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

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private String codeCdt;
    private String email;
    private Date birthDate;
    private String sexe;
    private String adress;
    private Integer childrenNum;
    private Integer exprience_num;
    private String phone;
    private String quartier;
    private String created_at;
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
    @ManyToOne
    private Civility civility;
    @JsonIgnore
    @OneToMany(mappedBy = "candidates")
    Collection<Interviews> interviews;  
    @OneToMany(mappedBy = "candidates")
    @JsonIgnore
    Collection<CdtPostes> cdtPostes;
    @OneToMany(mappedBy = "candidates")
    Collection<Attachements> attachements;

}

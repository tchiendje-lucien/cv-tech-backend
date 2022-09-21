package peoplelocation.peoplelocation.entites.projection;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.rest.core.config.Projection;

import peoplelocation.peoplelocation.entites.AcademicLevels;
import peoplelocation.peoplelocation.entites.Attachements;
import peoplelocation.peoplelocation.entites.CdtPostes;
import peoplelocation.peoplelocation.entites.Civility;
import peoplelocation.peoplelocation.entites.Nationality;
import peoplelocation.peoplelocation.entites.Speciality;
import peoplelocation.peoplelocation.entites.States;
import peoplelocation.peoplelocation.entites.Types;
import peoplelocation.peoplelocation.entites.Users;
import peoplelocation.peoplelocation.entites.Villes;

@Projection(name = "CommandProjection", types = { peoplelocation.peoplelocation.entites.Candidates.class })
public interface CandidatesView {

    public Long getOid();

    public String getFullname();

    public String getCodeCdt();

    public String getEmail();

    public Date getBirthDate();

    public String getSexe();

    public String getAdress();

    public Integer getChildrenNum();

    public Integer getExprience_num();

    public String getPhone();

    public String getQuartier();

    public Date getCreated_at();

    public Villes getVilles();

    public States getStates();

    public Types getTypes();

    public Speciality getSpeciality();

    public Nationality getNationality();

    public Users getUsers();

    public AcademicLevels getAcademicLevels();

    public Civility getCivility();

    public Collection<CdtPostes> getCdtPostes();

    public Attachements getAttachements();

}

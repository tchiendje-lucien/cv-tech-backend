package peoplelocation.peoplelocation.entites;

import java.io.Serializable;
import java.util.Collection;

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
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;
    private String fullname;
    private String userID;
    //@JsonProperty(access = Access.WRITE_ONLY )
    private String password;
    private String re_password;
    @ManyToOne
    private Rules rules;
    @JsonIgnore
    @OneToMany(mappedBy = "users")
    Collection<Candidates> candidates;
    @JsonIgnore
    @OneToMany(mappedBy = "users")
    Collection<Interviews> interviews;
}
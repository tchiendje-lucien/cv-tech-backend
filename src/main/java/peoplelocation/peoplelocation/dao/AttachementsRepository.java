package peoplelocation.peoplelocation.dao;
    

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import peoplelocation.peoplelocation.entites.Attachements;
import peoplelocation.peoplelocation.entites.Candidates;

@RepositoryRestResource
@CrossOrigin("*")
public interface AttachementsRepository extends JpaRepository<Attachements, Long>{
    Optional<Attachements> findByCandidates(Candidates candidates);
}
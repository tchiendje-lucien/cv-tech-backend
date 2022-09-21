package peoplelocation.peoplelocation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import peoplelocation.peoplelocation.entites.Candidates;
import peoplelocation.peoplelocation.entites.CdtPostes;

@RepositoryRestResource
@CrossOrigin("*")
public interface CdtPostesRepository extends JpaRepository<CdtPostes, Long> {
    public void deleteByCandidates(Candidates candidates);
}
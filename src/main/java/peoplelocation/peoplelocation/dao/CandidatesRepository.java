package peoplelocation.peoplelocation.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import peoplelocation.peoplelocation.entites.Candidates;

@RepositoryRestResource
@CrossOrigin("*")
public interface CandidatesRepository extends JpaRepository<Candidates, Long> {
    Optional<Candidates> findByFullname(String fullname);

    Optional<Candidates> findByPhone(String phone);
}
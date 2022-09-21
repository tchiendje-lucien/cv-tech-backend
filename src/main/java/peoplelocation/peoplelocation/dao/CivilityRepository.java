package peoplelocation.peoplelocation.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import peoplelocation.peoplelocation.entites.Civility;

@RepositoryRestResource
@CrossOrigin("*")
public interface CivilityRepository extends JpaRepository<Civility, Long> {
    Optional<Civility> findByName(String name);
}
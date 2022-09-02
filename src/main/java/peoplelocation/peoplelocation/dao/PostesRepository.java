package peoplelocation.peoplelocation.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import peoplelocation.peoplelocation.entites.Postes;

@RepositoryRestResource
@CrossOrigin("*")
public interface PostesRepository extends JpaRepository<Postes, Long> {
    Optional<Postes> findByName(String name);

}
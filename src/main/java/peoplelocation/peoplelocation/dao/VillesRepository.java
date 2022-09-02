package peoplelocation.peoplelocation.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import peoplelocation.peoplelocation.entites.Villes;

@RepositoryRestResource
@CrossOrigin("*")
public interface VillesRepository extends JpaRepository<Villes, Long> {

    Optional<Villes> findByName(String name);
}
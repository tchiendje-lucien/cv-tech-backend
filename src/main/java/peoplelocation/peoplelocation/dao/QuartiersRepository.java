package peoplelocation.peoplelocation.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import peoplelocation.peoplelocation.entites.Quartiers;


@RepositoryRestResource
@CrossOrigin("*")
public interface QuartiersRepository extends JpaRepository<Quartiers, Long>{
    Optional<Quartiers> findByName(String name);

}
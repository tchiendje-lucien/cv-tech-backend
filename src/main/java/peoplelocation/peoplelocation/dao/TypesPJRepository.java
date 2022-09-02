package peoplelocation.peoplelocation.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import peoplelocation.peoplelocation.entites.TypesPJ;

@RepositoryRestResource
@CrossOrigin("*")
public interface TypesPJRepository extends JpaRepository<TypesPJ, Long> {

    Optional<TypesPJ> findByName(String name);
}
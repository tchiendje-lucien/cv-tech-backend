package peoplelocation.peoplelocation.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import peoplelocation.peoplelocation.entites.Types;


@RepositoryRestResource
@CrossOrigin("*")
public interface TypesRepository extends JpaRepository<Types, Long>{
    Optional<Types> findByName(String name);

}
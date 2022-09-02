package peoplelocation.peoplelocation.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import peoplelocation.peoplelocation.entites.Rules;

@RepositoryRestResource
@CrossOrigin("*")
public interface RulesRepository extends JpaRepository<Rules, Long> {
    Optional<Rules> findByName(String name);

}
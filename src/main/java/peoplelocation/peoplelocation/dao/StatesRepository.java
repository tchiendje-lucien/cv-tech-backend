package peoplelocation.peoplelocation.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import peoplelocation.peoplelocation.entites.States;

@RepositoryRestResource
@CrossOrigin("*")
public interface StatesRepository extends JpaRepository<States, Long> {
    Optional<States> findByName(String name);

}
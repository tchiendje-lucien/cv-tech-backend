package peoplelocation.peoplelocation.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import peoplelocation.peoplelocation.entites.Nationality;

@RepositoryRestResource
@CrossOrigin("*")
public interface NationalityRepository extends JpaRepository<Nationality, Long> {
    Optional<Nationality> findByName(String name);
}
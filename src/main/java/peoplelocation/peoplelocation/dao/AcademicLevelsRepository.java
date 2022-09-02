package peoplelocation.peoplelocation.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import peoplelocation.peoplelocation.entites.AcademicLevels;

@RepositoryRestResource
@CrossOrigin("*")
public interface AcademicLevelsRepository extends JpaRepository<AcademicLevels, Long> {
    Optional<AcademicLevels> findByName(String name);
}
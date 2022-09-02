package peoplelocation.peoplelocation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import peoplelocation.peoplelocation.entites.Interviews;


@RepositoryRestResource
@CrossOrigin("*")
public interface InterviewsRepository extends JpaRepository<Interviews, Long>{

}
package peoplelocation.peoplelocation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import peoplelocation.peoplelocation.entites.Folders;


@RepositoryRestResource
@CrossOrigin("*")
public interface FoldersRepository extends JpaRepository<Folders, Long>{

}
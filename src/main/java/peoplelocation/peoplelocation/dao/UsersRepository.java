package peoplelocation.peoplelocation.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import peoplelocation.peoplelocation.entites.Users;

@RepositoryRestResource
@CrossOrigin("*")
public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByFullname(String fullname);

    Optional<Users> findByUserID(String userID);

   public Users findByUserIDOrFullname(String userID, String fullname);
}
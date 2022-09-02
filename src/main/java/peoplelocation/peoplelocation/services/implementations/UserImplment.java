package peoplelocation.peoplelocation.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import peoplelocation.peoplelocation.MessageReponse;
import peoplelocation.peoplelocation.dao.UsersRepository;
import peoplelocation.peoplelocation.entites.Users;
import peoplelocation.peoplelocation.services.interfaces.UserServices;

@Service
public class UserImplment implements UserServices {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public MessageReponse create_user(Users users) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (!usersRepository.findByFullname(users.getFullname()).isEmpty()) {
            return new MessageReponse("Ce nom est deja utilisé");
        }
        if (!usersRepository.findByUserID(users.getUserID()).isEmpty()) {
            return new MessageReponse("Cet identifiant est deja utilisé");
        }
        users.setFullname(users.getFullname());
        users.setRules(users.getRules());
        users.setUserID(users.getUserID());
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        usersRepository.save(users);
        return new MessageReponse("Compte creer avec success");
    }

    @Override
    public MessageReponse update_user(Users users) {
        if (!usersRepository.findByFullname(users.getFullname()).isEmpty()) {
            return new MessageReponse("Ce nom est deja utilisé");
        }
        if (!usersRepository.findByUserID(users.getUserID()).isEmpty()) {
            return new MessageReponse("Cet identifiant est deja utilisé");
        }
        Optional<Users> get_user = usersRepository.findById(users.getOid());
        if (get_user.isPresent()) {
            get_user.get().setFullname(users.getFullname());
            get_user.get().setUserID(users.getUserID());
            get_user.get().setRules(users.getRules());
            usersRepository.save(get_user.get());
            return new MessageReponse("Votre profil a été mis a jour avec success");
        } else {
            return new MessageReponse("Cet utilisateur n'existe pas");
        }
    }

    @Override
    public Users login(Users users) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Optional<Users> get_user = usersRepository.findByUserID(users.getUserID());
        System.out.println();
        if (get_user.isPresent()) {
            if (passwordEncoder.matches(users.getPassword(), get_user.get().getPassword())) {
                return get_user.get();
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public MessageReponse change_password(Users users) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Optional<Users> get_user = usersRepository.findByUserID(users.getUserID());
        if (get_user.isPresent()) {
            if (passwordEncoder.matches(users.getPassword(), get_user.get().getPassword())) {
                get_user.get().setPassword(passwordEncoder.encode(users.getRe_password()));
                usersRepository.save(get_user.get());
                return new MessageReponse("Mot de passe mit a jour avec success");
            } else {
                return new MessageReponse("Mot de passe different");
            }
        } else {
            return new MessageReponse("Cet utilisateur n'existe pas");
        }
    }

    @Override
    public List<Users> list_user() {
        return usersRepository.findAll();
    }

}

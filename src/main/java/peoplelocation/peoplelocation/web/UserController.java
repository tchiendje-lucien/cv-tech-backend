package peoplelocation.peoplelocation.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import peoplelocation.peoplelocation.MessageReponse;
import peoplelocation.peoplelocation.entites.Users;
import peoplelocation.peoplelocation.services.interfaces.UserServices;

@RestController
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserServices userServices;

    @PostMapping(value = "add_user")
    public MessageReponse add_user(@RequestBody Users users) {
        return userServices.create_user(users);
    }

    @PutMapping(value = "update_user")
    public MessageReponse update_user(@RequestBody Users users) {
        return userServices.update_user(users);
    }

    @PostMapping(value = "login")
    public Users login(@RequestBody Users users) {
        return userServices.login(users);
    }

    @PutMapping(value = "change_pwd")
    public MessageReponse change_pwd(@RequestBody Users users) {
        return userServices.change_password(users);
    }

    @GetMapping(value = "list_user")
    public List<Users> list_user(){
        return userServices.list_user();
    }
}

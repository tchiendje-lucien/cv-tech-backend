package peoplelocation.peoplelocation.services.interfaces;

import java.util.List;

import peoplelocation.peoplelocation.MessageReponse;
import peoplelocation.peoplelocation.entites.Users;

public interface UserServices {
    MessageReponse create_user(Users users);

    MessageReponse update_user(Users users);

    Users login(Users users);

    MessageReponse change_password(Users users);

    List<Users> list_user();
}

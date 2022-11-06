package dao;

import models.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    private List<User> users ;
    private static int USER_COUNT=0;
    {
        users= new ArrayList<>();
        users.add(new User(++USER_COUNT,"Tom","Cat"));
        users.add(new User(++USER_COUNT,"Brus","Lee"));
        users.add(new User(++USER_COUNT,"Alex","NoName"));

    }
    public List<User> index(){
        return users;
    }

    public  User show(int id){
        return users.stream().filter(user-> user.getId()==id).findAny().orElse(null);
    }

}

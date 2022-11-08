package PP_2_3_1.dao;

import PP_2_3_1.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    private List<User> users;
    private static int USER_COUNT = 0;

    {
        users = new ArrayList<>();
        users.add(new User(++USER_COUNT, "Tom", "Cat"));
        users.add(new User(++USER_COUNT, "Brus", "Lee"));
        users.add(new User(++USER_COUNT, "Alex", "NoName"));

    }

    public void saveUser(User user) {
        user.setId(++USER_COUNT);
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUserById(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public void update(int id, User updatedPerson) {
        User userToBeUpdated = getUserById(id);
        userToBeUpdated.setName(updatedPerson.getName());
        userToBeUpdated.setSurName(updatedPerson.getSurName());
    }

    public void delete(int id) {
        users.removeIf(p -> p.getId() == id);
    }


}

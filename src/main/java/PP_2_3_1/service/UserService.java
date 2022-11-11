package PP_2_3_1.service;

import PP_2_3_1.models.User;

import java.util.List;

public interface UserService {  void saveUser(User user);
    List<User> getUsers();
    User getUserById(int id);
    void update(User updatedUser);
    void delete(int id);
}

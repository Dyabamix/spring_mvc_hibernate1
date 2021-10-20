package web.DAO;

import web.models.Role;
import web.models.User;

import java.util.List;
import java.util.Set;

public interface UserDao {
    void add(User user);
    void update(User user);
    void delete(int id);
    List<User> getAllUsers();
    User getUser(int id);
    Role getRole(int role_id);
    List<Role> getAllRoles();
}

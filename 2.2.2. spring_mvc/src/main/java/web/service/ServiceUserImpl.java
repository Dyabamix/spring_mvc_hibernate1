package web.service;

import org.springframework.stereotype.Service;
import web.DAO.UserDao;
import web.models.Role;
import web.models.User;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ServiceUserImpl implements ServiceUser{

    private UserDao userDao;

    public ServiceUserImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUser(int id){
        return userDao.getUser(id);
    }

    @Override
    public Role getRole(int role_id) {
        return userDao.getRole(role_id);
    }

    @Override
    public List<Role> getAllRoles() {
        return userDao.getAllRoles();
    }
}

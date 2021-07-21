package web.service;

import web.models.User;

import java.util.List;

public interface ServiceUser {
    void add(User user);
    void update(User user);
    void delete(int id);
    List<User> getAllUsers();
}

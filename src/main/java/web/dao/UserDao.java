package web.dao;

import web.entity.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    void save(User user);

    void delete(int id);

    void update(User user);

    User getById(int id);
}

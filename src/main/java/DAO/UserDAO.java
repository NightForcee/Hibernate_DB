package DAO;

import entity.User;

import java.util.List;


public interface UserDAO {

    User add(User user);

    void delete(User user);

    void update(User user);

    User getByIb(int id);

    User getByName(String name);

    List<User> getAll();

    List<User> getAllByRoleName(String roleName);
}

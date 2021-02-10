package DAO;

import entity.Role;

import java.util.List;

public interface RoleDAO {
    Role getById(Integer id);

    Role getByName(String roleName);

    void add(Role role);

    void delete(Role role);

    void deleteByName(String roleName);

    void update(Role role);

    List<Role> getAll();

    List<Role> getAllByUserName(String userName);
}

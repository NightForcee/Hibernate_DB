package DAO.Impl;

import DAO.impl.RoleDAOImpl;
import DAO.impl.UserDAOImpl;
import entity.Role;
import entity.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class RoleDaoImplTest {
    private final UserDAOImpl userDAO = new UserDAOImpl();
    private final RoleDAOImpl roleDAO = new RoleDAOImpl();
    private Role role;
    private User user;

    @Test
    public void getById() {
        role = roleDAO.getById(1);
        Assert.assertNotNull(role);
        System.out.println(roleDAO.getById(1));
    }

    @Test
    public void getByName() {
        role = roleDAO.getByName("admin");
        Assert.assertNotNull(role);
        System.out.println(roleDAO.getByName(role.getName()));
    }

    @Test
    public void create() {
        role.setName("Driver");
        Assert.assertNotNull(role);
        roleDAO.add(role);
    }

    @Test
    public void deleteByName() {
        role = roleDAO.getByName("Driver");
        Assert.assertNotNull(role);
        roleDAO.deleteByName(role.getName());
    }

    @Test
    public void delete() {
        role = roleDAO.getByName("Driver");
        Assert.assertNotNull(role);
        role.setName("DriverForDelete");
        roleDAO.delete(role);
        System.out.println("Role Successfully delete");
    }

    @Test
    public void update() {
        role = roleDAO.getById(2);
        Assert.assertNotNull(role);
        roleDAO.update(role);
    }

    @Test
    public void getAll() {
        List<Role> expected = roleDAO.getAll();
        Assert.assertNotNull("Don't have roles", expected);
        roleDAO.getAll().forEach(System.out::println);
    }


    @Test
    public void getAllByUserName() {
        user = userDAO.getByName("loginAdmin");
        Assert.assertNotNull(user);
        roleDAO.getAllByUserName(user.getLogin()).forEach(System.out::println);
    }
}
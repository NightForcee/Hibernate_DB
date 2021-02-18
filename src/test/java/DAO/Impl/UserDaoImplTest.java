package DAO.Impl;

import DAO.Implementation.RoleDAOImpl;
import DAO.Implementation.UserDAOImpl;
import DAO.RoleDAO;
import DAO.UserDAO;
import entity.Role;
import entity.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UserDaoImplTest {
    private final UserDAO userDAO = new UserDAOImpl();
    private final RoleDAO roleDAO = new RoleDAOImpl();
    private User user;
    private Role role;

    @Before
    public void setUp() {
        System.out.println("-------------------------------------------------");
    }

    @Test
    public void addAndUpdateAndDelete_NOT_NULL_USER() {
        user = new User("LoginWithNullPass","12345");
        Assert.assertNotNull("User is not initialize", user);
        role = roleDAO.getByName("user");
        Assert.assertNotNull("User is not initialize", role);
        String expected = "user";
        Assert.assertEquals(expected,role.getName());
        user.addRole(role);
        userDAO.add(user);

        user.setPassword("12345");
        userDAO.update(user);

        userDAO.delete(user);
    }

    @Test
    public void update() {
        user = userDAO.getByName("TEST_BY_JUNIT");
        role = roleDAO.getByName("user");
        Assert.assertNotNull("User is not initialize", user);
        Assert.assertNotNull("Role is not initialize", role);

        String expected = "user";
        Assert.assertEquals(expected, role.getName());
        user.setPassword("12345");
        user.addRole(role);
        userDAO.update(user);
    }

    @Test
    public void AddAndDeleteUser() {
        user = new User("userForSafeAndDelete", "12345");
        Assert.assertNotNull("User is not initialize", user);
        role = roleDAO.getByName("user");
        Assert.assertNotNull("Role is not initialize", role);
        user.addRole(role);
        userDAO.add(user);

        Assert.assertNotNull("User is not initialize", user);
        userDAO.delete(user);
    }

    @Test
    public void getById() {
        user = userDAO.getByIb(1);
        Assert.assertNotNull("User is not initialize", user);
        System.out.println(userDAO.getByIb(user.getId()));
    }

    @Test
    public void getByName() {
        user = userDAO.getByIb(1);
        Assert.assertNotNull("User is not initialize", user);
        System.out.println(userDAO.getByName(user.getLogin()));
    }

    @Test
    public void getAllUsers_NO_NULL() {
        List<User> expected = userDAO.getAll();
        Assert.assertNotNull(expected);
        userDAO.getAll().forEach(System.out::println);
    }

    @Test
    public void getAllByRoleName() {
        List<User> expected = userDAO.getAllByRoleName("user");
        Assert.assertNotNull(expected);
        userDAO.getAllByRoleName("user").forEach(System.out::println);
    }

    @After
    public void closeSetUp() {
        System.out.println("-------------------------------------------------");
    }
}

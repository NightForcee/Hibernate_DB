package DAO.Implementation;

import entity.Role;
import entity.User;

public class UserDAOImplTest {
    private final UserDAOImpl userDAO = new UserDAOImpl();
    private final RoleDAOImpl roleDAO = new RoleDAOImpl();

    @org.junit.Test
    public void getById() {
        System.out.println(userDAO.getByIb(1));
    }

    @org.junit.Test
    public void getByName() {
        System.out.println(userDAO.getByName("loginUser"));
    }

    @org.junit.Test
    public void add() {
        User user = new User();
        user.setLogin("TestForDelete");
        user.setPassword("test");
        userDAO.add(user);
    }

    @org.junit.Test
    public void delete() {
        User user = new User();
        user.setLogin("TestForDelete");
        user.setPassword("test");
        userDAO.add(user);
        Role role = roleDAO.getById(2);
        user.addRole(role);
        userDAO.update(user);
        System.out.println("UPDATE user");

        userDAO.delete(user);
        System.out.println("DELETE user");
    }


    @org.junit.Test
    public void update() {
        User user = userDAO.getByIb(1);
        Role role = roleDAO.getById(2);
        user.addRole(role);
        userDAO.update(user);
    }

    @org.junit.Test
    public void getAll() {
        userDAO.getAll().forEach(System.out::println);
    }

    @org.junit.Test
    public void getAllByRoleName() {
        userDAO.getAllByRoleName("USER").forEach(System.out::println);
    }
}
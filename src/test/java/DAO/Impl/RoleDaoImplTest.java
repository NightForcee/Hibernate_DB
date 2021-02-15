package DAO.Impl;

import DAO.Implementation.RoleDAOImpl;
import DAO.Implementation.UserDAOImpl;
import entity.Role;
import org.junit.Test;

public class RoleDaoImplTest {
    private final UserDAOImpl userDAO = new UserDAOImpl();
    private final RoleDAOImpl roleDAO = new RoleDAOImpl();

    @Test
    public void getById() {
        System.out.println(roleDAO.getById(1));
    }

    @Test
    public void getByName() {
        System.out.println(roleDAO.getByName("ADMIN"));
    }

    @Test
    public void create() {
        Role role = new Role();
        role.setName("Driver");
        roleDAO.add(role);
    }

    @Test
    public void deleteByName() {
        roleDAO.deleteByName("Driver");
    }

    @Test
    public void delete() {
        Role role = new Role();
        role.setName("Driver");
        roleDAO.add(role);
        System.out.println("Role Successfully add");
        roleDAO.delete(role);
        System.out.println("Role Successfully delete");
    }


    @Test
    public void update() {
        Role role = roleDAO.getById(2);
        roleDAO.update(role);
        System.out.println("Role UPDATE");
    }

    @Test
    public void getAll() {
        roleDAO.getAll().forEach(System.out::println);
    }


    @Test
    public void getAllByUserName() {
        roleDAO.getAllByUserName("loginAdmin").forEach(System.out::println);
    }
}
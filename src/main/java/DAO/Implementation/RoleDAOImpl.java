package DAO.Implementation;

import DAO.RoleDAO;
import entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utility.HibernateUtil;

import java.util.List;

public class RoleDAOImpl implements RoleDAO {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public Role getById(Integer id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Role role = session.get(Role.class, id);
        session.getTransaction().commit();
        session.close();
        return role;
    }

    @Override
    public Role getByName(String roleName) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Role role = (Role) session.createQuery("FROM Role r WHERE r.name =:name")
                .setParameter("name", roleName).list().get(0);
        session.getTransaction().commit();
        session.close();
        return role;
    }

    @Override
    public void add(Role role) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(role);
        System.out.println("Add User in DB Successfully!");
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Role role) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Role role1 = (Role) session.load(Role.class, role.getId());
        session.delete(role1);
        System.out.println("DELETE role successfully!");
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteByName(String roleName) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Role role = (Role) session.createQuery("FROM Role WHERE name =:roleName ")
                .setParameter("roleName", roleName).list().get(0);
        session.delete(role);
        System.out.println("Role Successfully DELETE");
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Role role) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Role role1 = session.load(Role.class, role.getId());
        session.update(role1);
        System.out.println("UPDATE role successfully!");
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Role> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Role> roles = session.createQuery("FROM Role ").list();
        session.getTransaction().commit();
        session.close();
        return roles;
    }

    @Override
    public List<Role> getAllByUserName(String userName) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Role> roles = session.createQuery("FROM Role u LEFT JOIN fetch u.users as uUsers " +
                "WHERE uUsers.login =:userName")
                .setParameter("userName", userName).list();
        session.getTransaction().commit();
        session.close();
        return roles;
    }
}

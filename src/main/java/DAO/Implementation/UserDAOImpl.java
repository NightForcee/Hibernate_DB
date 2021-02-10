package DAO.Implementation;

import DAO.UserDAO;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utility.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public User getByIb(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = (User) session.createQuery("SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.id =:id")
                .setParameter("id", id).list().get(0);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public User getByName(String byName) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = (User) session.createQuery("SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.login =:byName ")
                .setParameter("byName", byName).list().get(0);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public void add(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        System.out.println("Add User in DB Successfully!");
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(user);
        System.out.println("DELETE user successfully!");
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        User user1 = (User) session.get(User.class, user.getId());
        user1.setLogin(user.getLogin());
        user1.setPassword(user.getPassword());
        user1.setRoles(user.getRoles());
        session.update(user1);

        System.out.println("UPDATE user successfully!");
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<User> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<User> users = session.createQuery("SELECT DISTINCT u from User u LEFT  JOIN fetch u.roles ").list();
        session.getTransaction().commit();
        session.close();
        return users;
    }

    @Override
    public List<User> getAllByRoleName(String roleName) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List<User> users = session.createQuery("SELECT u FROM User u LEFT JOIN FETCH u.roles role " +
                    "WHERE role.name =:roleName").setParameter("roleName", roleName).list();
            session.getTransaction().commit();
            return users;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return new ArrayList();
    }
}

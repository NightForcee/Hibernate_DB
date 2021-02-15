package servlets.util.impl;

import DAO.Implementation.UserDAOImpl;
import DAO.UserDAO;
import entity.User;
import servlets.util.UserUtils;

public class UserUtilsImpl implements UserUtils {
    private final UserDAO userDAO = new UserDAOImpl();

    @Override
    public boolean userIsExists(String userName, String userPassword) {
        boolean result = false;
        for (User user : userDAO.getAll()) {
            if (user.getLogin().equals(userName) && user.getPassword().equals(userPassword)) {
                result = true;
                break;
            }
        }
        return result;
    }
}

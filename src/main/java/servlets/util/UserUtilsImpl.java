package servlets.util;

import DAO.UserDAO;
import DAO.impl.UserDAOImpl;
import entity.User;

public class UserUtilsImpl implements UserUtils {
    UserDAO userDAO = new UserDAOImpl();

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

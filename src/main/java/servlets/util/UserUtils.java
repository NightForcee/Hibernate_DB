package servlets.util;

import entity.User;

public interface UserUtils {
    boolean userIsExists(final String userName, final String userPassword);
}

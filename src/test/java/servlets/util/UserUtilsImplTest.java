package servlets.util;

import DAO.UserDAO;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.*;

public class UserUtilsImplTest {

    @Mock
    UserDAO userDAO;

    @InjectMocks
    UserUtils userUtils = new UserUtilsImpl();

    @Test
    public void userIsExists_TRUE() {
        boolean result = userUtils.userIsExists("loginAdmin", "admin");
        Assert.assertTrue(result);
    }

    @Test
    public void userIsExists_FALSE() {
        boolean result = userUtils.userIsExists("login", "pass");
        Assert.assertFalse(result);
    }
}
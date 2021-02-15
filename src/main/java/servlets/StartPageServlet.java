package servlets;

import DAO.Implementation.RoleDAOImpl;
import DAO.RoleDAO;
import entity.Role;
import servlets.util.UserUtils;
import servlets.util.impl.UserUtilsImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/start")
public class StartPageServlet extends HttpServlet {
    private final UserUtils userUtils = new UserUtilsImpl();
    private final RoleDAO roleDAO = new RoleDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String login = (String) session.getAttribute("name");
        String password = (String) session.getAttribute("pass");

        if (userUtils.userIsExists(login, password)) {
            List<Role> roles = roleDAO.getAllByUserName(login);
            String roleName = req.getParameter("requiredRole");
            if (roleName == null) {
                roleName = roles.get(0).getName();
            }
            String finalRoleName = roleName;
            roles.removeIf(r -> r.getName().equals(finalRoleName));

            req.setAttribute("roles", roles);
            req.getRequestDispatcher("/WEB-INF/view/" + roleName + ".jsp").forward(req, resp);
        } else {
            req.setAttribute("error", "Bad input parameters");
            req.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(req, resp);
        }
        req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String login = req.getParameter("name");
        String password = req.getParameter("pass");

        if (userUtils.userIsExists(login, password)) {
            session.setAttribute("name", login);
            session.setAttribute("pass", password);
        } else {
            session.setAttribute("error", "Bad input parameters");
        }
        doGet(req, resp);
    }
}

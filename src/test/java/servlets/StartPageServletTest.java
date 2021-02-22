package servlets;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import servlets.util.UserUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class StartPageServletTest {
    @Mock
    UserUtils userUtils;

    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @Mock
    HttpSession session;

    @Mock
    RequestDispatcher rd;

    @InjectMocks
    StartPageServlet startPageServlet = new StartPageServlet();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void userIsExistAndAdmin_TRUE() throws IOException, ServletException {
        when(request.getParameter("name")).thenReturn("loginAdmin");
        when(request.getParameter("pass")).thenReturn("admin");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(ArgumentMatchers.anyString())).thenReturn(rd);
        startPageServlet.doPost(request, response);
        when(userUtils.userIsExists("loginAdmin", "admin")).thenReturn(true);
        verify(session).setAttribute("name", "loginAdmin");
        verify(session).setAttribute("pass", "admin");
    }

    @Test
    public void userIsExistAndManager_TRUE() throws IOException, ServletException {
        when(request.getParameter("name")).thenReturn("loginManager");
        when(request.getParameter("pass")).thenReturn("manager");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(ArgumentMatchers.anyString())).thenReturn(rd);
        startPageServlet.doPost(request, response);
        when(userUtils.userIsExists("loginManager", "manager")).thenReturn(true);
        verify(session).setAttribute("name", "loginManager");
        verify(session).setAttribute("pass", "manager");
    }

    @Test
    public void userIsExistAndUser_TRUE() throws IOException, ServletException {
        when(request.getParameter("name")).thenReturn("loginUser");
        when(request.getParameter("pass")).thenReturn("user");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(ArgumentMatchers.anyString())).thenReturn(rd);
        startPageServlet.doPost(request, response);
        when(userUtils.userIsExists("loginUser", "user")).thenReturn(true);
        verify(session).setAttribute("name", "loginUser");
        verify(session).setAttribute("pass", "user");
    }

    @Test
    public void userIsNotExistAndError() throws ServletException, IOException {
        when(request.getParameter("name")).thenReturn("loginError");
        when(request.getParameter("pass")).thenReturn("error");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(ArgumentMatchers.anyString())).thenReturn(rd);
        startPageServlet.doPost(request, response);
        when(userUtils.userIsExists("loginError", "error")).thenReturn(false);
        verify(session).setAttribute("error", "Bad input parameters");
        assertFalse(userUtils.userIsExists("loginError", "error"));
    }
}